/*
 * NameServiceImplementationTest.java
 * Mary-Beth Agulhas
 * 219082367
 * 18 June 2022
 */
package za.ac.cput.schoolmanagement.service.impl;

import org.junit.jupiter.api.*;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.factory.NameFactory;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class NameServiceImplementationTest {
    private final Name name =NameFactory.build("Amy","Liz","Louw");
    private NameServiceImplementation Service;

//builds a name
    @BeforeEach
    void setup(){
        this.Service = NameServiceImplementation.getNameService();

    }

    @Test
//saves name
    public void save(){

        Name saved =this.Service.save(this.name);
        assertNotNull(saved);
        assertSame(this.name,saved);
        System.out.println(saved);
    }


   /* @Test
//reads name
    void reader() {
        this.Service.reader(name);
        System.out.println(this.Service.reader(name));
    }*/


    @Test
//finds all names
    void findAll() {
        this.Service.save(this.name);
        List<Name> nameList = this.Service.findAll();
        assertEquals(1, nameList.size());
        System.out.println(this.Service.findAll());
    }


    @Test
//deletes names
    @AfterEach
    void  teardown(){
        this.Service.delete(this.name);
        List<Name> nameList = this.Service.findAll();
        assertEquals(0, nameList.size());

    }
}

