package com.accenture.microempleado.model;

public enum OfficeLocation {

    BUENOS_AIRES {
        public String toString() {
            return "Buenos Aires Roque Saenz Peña";
        }
    },
    ROSARIO {
        public String toString() {
            return "Rosario Santa Fe";
        }
    },
    LA_PLATA {
        public String toString() {
            return "Buenos Aires - La Plata";
        }
    },
    MIGUELETES {
        public String toString() {
            return "Buenos Aires Migueletes";
        }
    }
}