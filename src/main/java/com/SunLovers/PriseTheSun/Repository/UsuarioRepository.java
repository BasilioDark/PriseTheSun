package com.SunLovers.PriseTheSun.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SunLovers.PriseTheSun.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos de consulta personalizados para a entidade Usuario

    //exemplo 0: Cadastra um novo Usuario
    <S extends Usuario> S save(S entity);

    // Exemplo 1: Encontrar um usuário pelo nome
    Usuario findByCpf(String cpf);
    //verificar se existe usuario
    boolean existsByCpf(String cpf);
    // Exemplo 2: verifica se ja tem um usuario com o nome digitado
}
