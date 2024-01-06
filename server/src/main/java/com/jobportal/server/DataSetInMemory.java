package com.jobportal.server;

import com.jobportal.server.entity.Company;
import com.jobportal.server.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataSetInMemory {
    private User[] loggedInUsers;
    private Company[] loggedInCompanies;
}
