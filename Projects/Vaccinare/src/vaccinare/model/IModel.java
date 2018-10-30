/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinare.model;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lucas.270498
 */
public interface IModel {
    public void insert () throws SQLException, ClassNotFoundException ;
    public void update() throws Exception ;
    public void delete() throws Exception ;
    public void selectAttributes(int id) throws Exception ;
}
