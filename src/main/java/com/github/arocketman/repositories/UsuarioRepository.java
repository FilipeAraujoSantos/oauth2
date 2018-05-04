package com.github.arocketman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.arocketman.entities.Usuario;

/**
 * User repository for CRUD operations.
 */
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByNome(String nome);
}
