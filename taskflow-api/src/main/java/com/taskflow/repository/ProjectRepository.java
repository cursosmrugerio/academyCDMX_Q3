package com.taskflow.repository;

import com.taskflow.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProjectRepository — mismo swap que TaskRepository (MP-6): de interfaz + InMemoryProjectRepository a
 * extends JpaRepository&lt;Project, Long&gt;. save/findById/findAll/deleteById gratis, sin adaptadores
 * (las firmas se alinearon a Spring Data desde D3). InMemoryProjectRepository SE ELIMINÓ.
 *
 * ProjectService sí se tocó hoy (MP-4 owner->ownerId, MP-6 tareasDe->findByProjectId), pero la
 * promesa del día protege a TaskService, no a ProjectService — y ese toque no viene del repositorio,
 * viene del aplanamiento del modelo. El contrato del repo (estos 4 métodos) no cambió.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
