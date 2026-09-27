#!/usr/bin/env python3
"""Ronda 3 (27-sep-2026): las preguntas con clave de la página «sin respuesta» pasan a las autoevaluaciones.

Lee banco-publicado-r2.json (el banco que se publicó el 25-sep, copia intacta de banco-final.json) y cambios-r3.json,
y escribe banco-final.json, que es lo que lee 27_generar_plan.py. Aborta si algo no cuadra.

Uso: python3 aplicar-r3.py
"""
import json, os, sys

D = os.path.dirname(os.path.abspath(__file__))
PREV = os.path.join(D, 'banco-publicado-r2.json')
banco = json.load(open(PREV))
cambios = json.load(open(os.path.join(D, 'cambios-r3.json')))['cambios']
por = {b['grupo']: b for b in banco}

for g, c in cambios.items():
    b = por.get(g) or sys.exit(f'ABORTA: {g} no está en el banco')
    if b['destino'] != 'instructor': sys.exit(f'ABORTA: {g} no estaba en la página «sin respuesta» (destino={b["destino"]})')
    if b['correctas']: sys.exit(f'ABORTA: {g} ya tenía correctas {b["correctas"]}')
    quitar = set(c.get('quitar_opciones', []))
    letras = [o[0] for o in b['opciones']]
    if not quitar <= set(letras): sys.exit(f'ABORTA: {g} quita opciones que no existen: {sorted(quitar - set(letras))}')
    opciones = [o for o in b['opciones'] if o[0] not in quitar]
    cor = c['correctas']
    if not cor or not set(cor) <= {o[0] for o in opciones}: sys.exit(f'ABORTA: {g} correctas {cor} fuera de las opciones')
    if (c['tipo'] == 'single') != (len(cor) == 1): sys.exit(f'ABORTA: {g} tipo {c["tipo"]} con {len(cor)} correctas')
    if not c['retro'].startswith('Respuesta tomada de la clave del examen'): sys.exit(f'ABORTA: {g} retro sin el aviso de clave')
    antes = {k: b[k] for k in ('destino', 'respaldo', 'tipo', 'correctas', 'fuente', 'cita', 'retro')}
    b.update({'destino': 'cuestionario', 'respaldo': 'clave', 'tipo': c['tipo'], 'correctas': cor,
              'fuente': c['fuente'], 'cita': c['cita'], 'retro': c['retro'], 'opciones': opciones})
    b['cambios_r3'] = [f'instructor → cuestionario con la clave {c["fuente"]} (decisión del instructor 27-sep: la opción marcada en color es la correcta)']
    if quitar: b['cambios_r3'].append(f'quitadas las opciones {", ".join(sorted(quitar))}')
    b['antes_r3'] = antes

# Retoques de retroalimentación en preguntas que ya se calificaban (solo el texto; la respuesta no cambia).
for g, c in json.load(open(os.path.join(D, 'cambios-r3.json'))).get('retoques', {}).items():
    b = por.get(g) or sys.exit(f'ABORTA: {g} no está en el banco')
    if b['destino'] != 'cuestionario': sys.exit(f'ABORTA: retoque en {g}, que no se califica')
    b['cambios_r3_retro'] = {'antes': b['retro']}; b['retro'] = c['retro']
json.dump(banco, open(os.path.join(D, 'banco-final.json'), 'w'), ensure_ascii=False, indent=1)
n = lambda f: sum(1 for b in banco if f(b))
print(f'banco-final.json: {len(banco)} preguntas · {len(cambios)} cambiadas')
print(f'  cuestionario: {n(lambda b: b["destino"] == "cuestionario")} (doc {n(lambda b: b["destino"] == "cuestionario" and b["respaldo"] == "doc")}, '
      f'clave {n(lambda b: b["destino"] == "cuestionario" and b["respaldo"] == "clave")})')
print(f'  sin respuesta confirmada: {n(lambda b: b["destino"] == "instructor")} (ninguno {n(lambda b: b["respaldo"] == "ninguno")}, '
      f'contradictorio {n(lambda b: b["respaldo"] == "contradictorio")})')
