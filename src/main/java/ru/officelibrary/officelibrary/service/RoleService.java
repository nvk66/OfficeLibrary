package ru.officelibrary.officelibrary.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.officelibrary.officelibrary.entity.Role;
import ru.officelibrary.officelibrary.repository.RoleRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> roleList() {
        return (List<Role>) roleRepository.findAll();
    }

    public List<Role> findRoleByIdList(String [] ids){
        return roleRepository.findRoleByIdList(Stream.of(ids).map(Long::valueOf).collect(Collectors.toList()));
    }

    public Role getRole(Long id){
        return roleRepository.findById(id).get();
    }

    public Role getRole(String roleName){
        return roleRepository.findRoleByRoleName(roleName);
    }

}
