package com.ttn.assignment.feb_20.exercise9;

import java.util.Arrays;
import java.util.List;

/**
 * Design classes having attributes for furniture where there are wooden chairs and tables, metal chairs and tables.
 * There are stress and fire tests for each products.
 */
public class Exercise9 {
    public static void main(String[] args) {
        Chair chair = new Chair(2999.99f, FurnitureType.METAL, ChairType.DINING);
        Chair chair1 = new Chair(25130.99f, FurnitureType.WOODEN, ChairType.RECLINER);
        Chair chair2 = new Chair(12545.99f, FurnitureType.WOODEN, ChairType.ROCKING);
        Chair chair3 = new Chair(5545.99f, FurnitureType.METAL, ChairType.FOLDING);

        Table table = new Table(15000.99f, FurnitureType.METAL, TableType.DINING);
        Table table1 = new Table(12000.99f, FurnitureType.WOODEN, TableType.STUDY);
        Table table2 = new Table(10000.99f, FurnitureType.WOODEN, TableType.DRESSING);
        Table table3 = new Table(22000.99f, FurnitureType.WOODEN, TableType.POOL);
/*
      Subtyping describes type relationships, and subtype polymorphism enables operations defined for supertypes
      to be safely substituted with subtypes. Here,Chair/Table is the subtype of Furniture and Furniture is the
      supertype of Chair/Table. In simpler terms, Chair/Table “is a” Furniture, but Furniture is not a Chair/Table.
      This means that all operations that apply to the Furniture data type should accept operating on data of type
      Chair/Table; however, the reverse is not true: operations defined for the data type Chair/Table would not
      safely be able to operate on data of type Furniture i.e getChairType/getTableType won't work with furnitureList's
      Objects.
*/
        List<Furniture> furnitureList = Arrays.asList(chair, chair1, chair2, chair3, table, table1, table2, table3);

        for (Furniture furniture : furnitureList) {
            System.out.println(furniture.fire());
            System.out.println(furniture.stress());
        }
    }
}
