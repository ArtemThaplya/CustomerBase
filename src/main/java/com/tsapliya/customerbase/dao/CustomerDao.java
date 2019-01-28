package com.tsapliya.customerbase.dao;

import com.tsapliya.customerbase.model.Customer;
import com.tsapliya.customerbase.model.StatusCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDao {
    private final JdbcTemplate template;

    @Autowired
    public CustomerDao(JdbcTemplate template) {
        this.template = template;
    }

    public int create(Customer p) {
        String sql = "INSERT INTO customer (fullName, date, inn, familyStatus, education, status) VALUES('" + p.getFullName() + "'," + p.getDate() + ",'" + p.getInn() + ",'" + p.getFamilyStatus() + ",'" + p.getEducation() + ",'" + p.getStatus() + "')";
        return template.update(sql);
    }

    public int update(Customer p) {
        String sql = "UPDATE customer SET fullName='" + p.getFullName() + "',date='" + p.getDate() + "',inn='" + p.getInn() + "',familyStatus='" + p.getFamilyStatus() + "',education='" + p.getEducation() + "',status='" + p.getStatus() + "' WHERE id=" + p.getId() + "";
        return template.update(sql);
    }

    public int delete(int id) {
        String sql = "DELETE FROM customer WHERE id=" + id + "";
        return template.update(sql);
    }

    public Customer getEmpById(int id) {
        String sql = "SELECT * FROM customer WHERE id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Customer.class));
    }

    public List<Customer> getEmployees() {
        return template.query("SELECT * FROM customer", (rs, row) -> {
            Customer e = new Customer();
            e.setId(rs.getInt(1));
            e.setFullName(rs.getString(2));
            e.setDate(rs.getDate(3));
            e.setInn(rs.getLong(4));
            e.setFamilyStatus(rs.getString(5));
            e.setEducation(rs.getString(6));
            e.setStatus(StatusCustomer.valueOf(rs.getString(7)));
            return e;
        });
    }
}  