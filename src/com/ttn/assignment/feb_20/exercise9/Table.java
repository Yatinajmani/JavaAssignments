package com.ttn.assignment.feb_20.exercise9;

class Table extends Furniture {
    private TableType tableType;

    private TableType getTableType() {
        return tableType;
    }

    Table(float price, FurnitureType furnitureType, TableType tableType) {
        super(price, furnitureType);
        this.tableType = tableType;
    }

    @Override
    String fire() {
        return "Fire Test running for : " + getTableType().toString().toLowerCase() + " type " + getFurnitureType().toString().toLowerCase() + " Table of price : Rs." + getPrice();
    }

    @Override
    String stress() {
        return "Stress Test running for : " + getTableType().toString().toLowerCase() + " type " + getFurnitureType().toString().toLowerCase() + " Table of price : Rs." + getPrice();
    }
}
