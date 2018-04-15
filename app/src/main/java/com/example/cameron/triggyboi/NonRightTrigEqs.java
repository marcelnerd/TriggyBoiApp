package com.example.cameron.triggyboi;

public class NonRightTrigEqs {

    private double sideA, angleA, sideB, angleB, sideC, angleC;
    boolean sideASolved, angleASolved, sideBSolved, angleBSolved, sideCSolved, angleCSolved, triangleChanged;

    public void setVars(double sA, double aA, double sB, double aB, double sC, double aC) {
        sideA = sA;
        angleA = aA;
        sideB = sB;

        angleB = aB;
        sideC = sC;
        angleC = aC;

        sideASolved = (sA>0);
        angleASolved = (aA>0);
        sideBSolved = (sB>0);
        angleBSolved = (aB>0);
        sideCSolved = (sC>0);
        angleCSolved = (aC>0);

        triangleChanged = true;
    }


    public void solveTriangle() {
        while(triangleChanged) {
            triangleChanged = false;
            calcSideA();
            calcAngleA();
            calcSideB();
            calcAngleB();
            calcSideC();
            calcAngleC();
        }
    }

    void calcSideA() {
        if(!sideASolved) {
            if(sideBSolved && angleBSolved && angleASolved) {
                sideA = (sideB * Math.sin(Math.toRadians(angleA))) / Math.sin(Math.toRadians(angleB));
                sideASolved = true;
                triangleChanged = true;
                return;
            }
            if(sideCSolved && angleASolved && angleCSolved) {
                sideA = (sideC * Math.sin(Math.toRadians(angleA))) / Math.sin(Math.toRadians(angleC));
                sideASolved = true;
                triangleChanged = true;
                return;
            }
            if(sideBSolved && sideCSolved && angleASolved) {
                sideA = Math.sqrt((Math.pow(sideB, 2) + Math.pow(sideC, 2)) - (2 * sideB * sideC * Math.cos(Math.toRadians(angleA))));
                sideASolved = true;
                triangleChanged = true;
                return;
            }

        }
    }

    void calcSideB() {

        if(!sideBSolved) {
            if(sideASolved && angleBSolved && angleASolved) {
                sideB = (sideA * Math.sin(Math.toRadians(angleB))) / Math.sin(Math.toRadians(angleA));
                sideBSolved = true;
                triangleChanged = true;
                return;
            }
            if(sideCSolved && angleBSolved && angleCSolved) {
                sideB = (sideC * Math.sin(Math.toRadians(angleB))) / Math.sin(Math.toRadians(angleC));
                sideBSolved = true;
                triangleChanged = true;
                return;
            }
            if(sideASolved && sideCSolved && angleBSolved) {
                sideB = Math.sqrt((Math.pow(sideA, 2) + Math.pow(sideC, 2)) - (2 * sideA * sideC * Math.cos(Math.toRadians(angleB))));
                sideBSolved = true;
                triangleChanged = true;
                return;
            }

        }

    }

    void calcSideC() {
        if(!sideCSolved) {
            if(sideBSolved && angleBSolved && angleCSolved) {
                sideC = (sideB * Math.sin(Math.toRadians(angleC))) / Math.sin(Math.toRadians(angleB));
                sideCSolved = true;
                triangleChanged = true;
                return;
            }
            if(sideASolved && angleASolved && angleCSolved) {
                sideC = (sideA * Math.sin(Math.toRadians(angleC))) / Math.sin(Math.toRadians(angleA));
                sideCSolved = true;
                triangleChanged = true;
                return;
            }
            if(sideBSolved && sideASolved && angleCSolved) {
                sideC = Math.sqrt((Math.pow(sideA, 2) + Math.pow(sideB, 2)) - (2 * sideA * sideB * Math.cos(Math.toRadians(angleC))));
                sideCSolved = true;
                triangleChanged = true;
                return;
            }

        }
    }

    void calcAngleA() {
        if(!angleASolved) {
            if(angleBSolved && sideASolved && sideBSolved) {
                angleA = Math.toDegrees(Math.asin((Math.sin(Math.toRadians(angleB)) * sideA) / sideB));
                angleASolved = true;
                triangleChanged = true;
                return;
            }
            if(angleCSolved && sideCSolved && sideASolved) {
                angleA = Math.toDegrees(Math.asin((Math.sin(Math.toRadians(angleC)) * sideA) / sideC));
                angleASolved = true;
                triangleChanged = true;
                return;
            }
            if(sideBSolved && sideASolved && sideCSolved) {
                angleA = Math.toDegrees(Math.acos((Math.pow(sideB, 2) + Math.pow(sideC, 2) - Math.pow(sideA, 2)) / (2 * sideB * sideC)));
                angleASolved = true;
                triangleChanged = true;
                return;
            }
        }
    }

    void calcAngleB() {
        if(!angleBSolved) {
            if(angleASolved && sideASolved && sideBSolved) {
                angleB = Math.toDegrees(Math.asin((Math.sin(Math.toRadians(angleA)) * sideB) / sideA));
                angleBSolved = true;
                triangleChanged = true;
                return;
            }
            if(angleCSolved && sideCSolved && sideBSolved) {
                angleB = Math.toDegrees(Math.asin((Math.sin(Math.toRadians(angleC)) * sideB) / sideC));
                angleBSolved = true;
                triangleChanged = true;
                return;
            }
            if(sideBSolved && sideASolved && sideCSolved) {
                angleB = Math.toDegrees(Math.acos((Math.pow(sideA, 2) + Math.pow(sideC, 2) - Math.pow(sideB, 2)) / (2 * sideA * sideC)));
                angleBSolved = true;
                triangleChanged = true;
                return;
            }
        }

    }

    void calcAngleC() {

        if(!angleCSolved) {
            if(angleASolved && sideASolved && sideCSolved) {
                angleC = Math.toDegrees(Math.asin((Math.sin(Math.toRadians(angleA)) * sideC) / sideA));
                angleCSolved = true;
                triangleChanged = true;
                return;
            }
            if(angleBSolved && sideCSolved && sideBSolved) {
                angleC = Math.toDegrees(Math.asin((Math.sin(Math.toRadians(angleB)) * sideC) / sideB));
                angleCSolved = true;
                triangleChanged = true;
                return;
            }
            if(sideBSolved && sideASolved && sideCSolved) {
                angleC = Math.toDegrees(Math.acos((Math.pow(sideB, 2) + Math.pow(sideA, 2) - Math.pow(sideC, 2)) / (2 * sideB * sideA)));
                angleCSolved = true;
                triangleChanged = true;
                return;
            }
        }
    }

    public double getSideC() {
        return sideC;
    }

    public double getAngleA() {
        return angleA;
    }

    public double getAngleB() {
        return angleB;
    }

    public double getAngleC() {
        return angleC;
    }
    public double getSideA() {
        return sideA;
    }
    public double getSideB() {
        return sideB;
    }
}
