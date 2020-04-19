package com.example.springbootvhr.service;

import com.example.springbootvhr.dao.HrDao;
import com.example.springbootvhr.dao.HrRoleDao;
import com.example.springbootvhr.entity.Hr;
import org.example.vhr.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrDao hrDao;
    @Autowired
    HrRoleDao hrRoleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrDao.queryUserByUserName(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        hr.setRoles(hrDao.getHrRoleById(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHrs(String keyWords) {
        return hrDao.getAllHrs(HrUtils.getCurrentHr().getId(), keyWords);
    }

    public Integer updateHr(Hr hr) {
        return hrDao.update(hr);
    }

    @Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        hrRoleDao.deleteByHrId(hrid);
        return hrRoleDao.addRoles(hrid, rids) == rids.length;
    }

    public int deleteHrById(Integer id) {
        return hrDao.deleteById(id);
    }
}
