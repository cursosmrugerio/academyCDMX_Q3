package com.taskflow.repository;

import com.taskflow.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProjectRepository — igual que TaskRepository: extends JpaRepository&lt;Project, Long&gt;, y
 * save/findById/findAll/deleteById vienen gratis, sin implementación ni adaptadores: un PROXY de
 * Spring Data la implementa en runtime.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
