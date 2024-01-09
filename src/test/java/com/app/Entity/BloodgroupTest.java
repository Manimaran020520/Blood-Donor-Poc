package com.app.Entity;



import com.app.Entity.Repository.bloodGroupRepository;
import com.app.Exception.bloodgroupNotFoundException;
import com.app.Service.bloodgroupService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


class BloodgroupTest {
    @Mock
    private bloodGroupRepository brepo;
    @InjectMocks
    private bloodgroupService bserv;

@Test
    public void testBloodGroupFields() {
    Bloodgroup bloodgroup = new Bloodgroup();
    bloodgroup.setBloodgroup("bloodgroup");
    assertEquals("bloodgroup", bloodgroup.getBloodgroup());
}




}

