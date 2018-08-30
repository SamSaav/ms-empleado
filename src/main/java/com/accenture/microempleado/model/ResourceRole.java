package com.accenture.microempleado.model;

public enum ResourceRole {
    ASSOCIATE {
        public String toString() {
            return "Application Development Associate";
        }
    },
    ANALYST {
        public String toString() {
            return "Application Development Analyst";
        }
    },
    SENIOR_ANALYST {
        public String toString() {
            return "Application Development Senior Analyst";
        }
    },
}