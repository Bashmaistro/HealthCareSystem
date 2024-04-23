package com.healthcaresystem.serviceimp;

import com.healthcaresystem.entity.Role;
import com.healthcaresystem.repository.RoleRepository;
import com.healthcaresystem.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(int rid) {
        Optional<Role> result = roleRepository.findById(rid);
        Role theRole = null;

        if (result.isPresent()){
            theRole = result.get();

        }else {
            throw new RuntimeException("Did not find employee id - " + rid);

        }
        return theRole;
    }

    @Override
    public Role save(Role theRole) {
        return roleRepository.save(theRole);
    }

    @Override
    public void deleteById(int rid) {

        roleRepository.deleteById(rid);
    }
}
