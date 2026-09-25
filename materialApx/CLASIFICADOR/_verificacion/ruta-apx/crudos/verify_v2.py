import json, re, sys
v1 = json.load(open('banco-v1.json'))
b = json.load(open('banco-v2.json'))
err = []
print('grupos', len(b))
if len(b) < 222: err.append('menos de 222 grupos')
gs = [q['grupo'] for q in b]
if len(set(gs)) != len(gs): err.append('grupos repetidos')
ids1 = sorted(m for q in v1 for m in q['miembros'])
ids2 = [m for q in b for m in q['miembros']]
if len(ids2) != len(set(ids2)): err.append('ids repetidos')
if sorted(ids2) != ids1: err.append('cobertura de miembros distinta de v1')
for q in b:
    if q['representante'] not in q['miembros']: err.append(q['grupo']+' representante fuera de miembros')
    if 'cambios_r1' not in q or not isinstance(q['cambios_r1'], list): err.append(q['grupo']+' sin cambios_r1')
print('ids', len(ids2), 'v1', len(ids1))
PHR = 'Respuesta tomada de la clave del examen (no la explica la documentación del curso).'
BAD = re.compile(r'2 - APX Online Components|APX Online Components|Ejemplo de Creación de Transacción|Ejemplo de DTO|Creación de librería|Introducción APX Batch|Conceptos APX Batch|Componentes APX BATCH', re.I)
for q in b:
    g = q['grupo']; letras = {o[0] for o in q['opciones']}
    if not set(q['correctas']) <= letras: err.append(g+' correctas fuera de opciones')
    if q['destino'] == 'cuestionario':
        if not q['correctas']: err.append(g+' cuestionario sin correctas')
        if q['tipo'] == 'single' and len(q['correctas']) != 1: err.append(g+' single con != 1 correcta')
        if q['respaldo'] not in ('doc', 'clave'): err.append(g+' cuestionario con respaldo '+q['respaldo'])
    elif q['destino'] == 'instructor':
        if q['correctas']: err.append(g+' instructor con correctas')
    else: err.append(g+' destino raro')
    r = q['retro'] or ''
    if len(r.split()) > 60: err.append(g+f' retro {len(r.split())} palabras')
    if q['respaldo'] == 'clave' and not r.startswith(PHR): err.append(g+' retro clave sin aviso')
    for k in ('retro', 'fuente', 'cita'):
        if q[k] and BAD.search(q[k]): err.append(g+f' {k} menciona archivo no disponible: '+BAD.search(q[k]).group(0))
    if re.search(r'\bcorpus\b|Curse_APX_Online(?!\.pptx)|Curse diap', r): err.append(g+' retro con nombre interno')
from collections import Counter
print(Counter((q['destino'], q['respaldo']) for q in b))
print('con cambios', sum(1 for q in b if q['cambios_r1']))
print('ERRORES:', len(err)); [print(' ', e) for e in err]
sys.exit(1 if err else 0)
