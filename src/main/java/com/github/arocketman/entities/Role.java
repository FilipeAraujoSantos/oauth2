package com.github.arocketman.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seq_role", sequenceName = "seq_role", initialValue = 1, allocationSize = 1)
@Table(name = "role")
public class Role {
	
	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role")
    private Long id;
	
	@Column(name="name", nullable=false)
    String name;
	
    Role() {}
    
    public Role(String name) {
        this.name = name;
    }
    
    // Get's & Set's
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
