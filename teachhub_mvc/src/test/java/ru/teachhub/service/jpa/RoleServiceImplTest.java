package ru.teachhub.service.jpa;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;

import ru.teachhub.domain.Role;
import ru.teachhub.service.RoleService;

public class RoleServiceImplTest extends AbstractServiceImplTest {

    @Autowired
    private RoleService roleService;

    private Role expectedAdminRole = new Role("admin", "11111111");

    private Role expectedTeacherRole = new Role("teacher", "11110000");

    private Role expectedStudentRole = new Role("student", "00000000");

    @Test
    @DatabaseSetup("RoleServiceImplTest.xml")
    public void findAll() throws Exception {
        List<Role> roles = roleService.findAll();

        Assert.assertNotNull(roles);
        Assert.assertEquals(3, roles.size());

        Role adminRole = roles.get(0);
        Role teacherRole = roles.get(1);
        Role studentRole = roles.get(2);

        Assert.assertEquals(expectedAdminRole, adminRole);
        Assert.assertEquals(expectedTeacherRole, teacherRole);
        Assert.assertEquals(expectedStudentRole, studentRole);
    }

    // @Test
    // @DatabaseSetup("RoleServiceImplTest.xml")
    // public void findByTitle() throws Exception {
    // List<Role> roles = roleService.findByTitle("admin");
    //
    // Assert.assertNotNull(roles);
    // Assert.assertEquals(1, roles.size());
    //
    // Role adminRole = roles.get(0);
    //
    // Assert.assertEquals(expectedAdminRole, adminRole);
    // }
    //
    // @Test
    // @DatabaseSetup("RoleServiceImplTest.xml")
    // public void errorFindByTitle() throws Exception {
    // String wrongTitle = "superadmin";
    // List<Role> roles = roleService.findByTitle(wrongTitle);
    //
    // Assert.assertNotNull(roles);
    // Assert.assertTrue("There is no role with '" + wrongTitle + "' title",
    // roles.isEmpty());
    // }

}
