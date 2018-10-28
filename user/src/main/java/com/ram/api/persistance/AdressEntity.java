package com.ram.api.persistance;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Table;

import lombok.Data;

@Data
@DynamicUpdate(true)
@Table(appliesTo="adress")
public class AdressEntity {

}
