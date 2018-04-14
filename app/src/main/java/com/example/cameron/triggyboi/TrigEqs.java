package com.example.cameron.triggyboi;

import android.util.Log;

public class TrigEqs {

    private double theta;
    private double deta;
    private double legA;
    private double legB;
    private double hypot;
    private boolean triangleChanged;
    private boolean thetaSolved;
    private boolean detaSolved;
    private boolean aSolved;
    private boolean bSolved;
    private boolean hypotSolved;

    public void setVars(double t, double d, double a, double b, double h) {
        theta = (t>0) ? t:0;
        deta = (d>0) ? d:0;
        legA = (a>0) ? a:0;
        legB = (b>0) ? b:0;
        hypot = (h>0) ? h:0;
        triangleChanged = true;
        thetaSolved = (t>0) ? true:false;
        detaSolved = (d>0) ? true:false;
        aSolved = (a>0) ? true:false;
        bSolved = (b>0) ? true:false;
        hypotSolved = (h>0) ? true:false;
        Log.i("vars", "Theta: " + theta);
        Log.i("vars", "Deta: " + deta);
        Log.i("vars", "A: " + legA);
        Log.i("vars", "B: " + legB);
        Log.i("vars", "Hypotenuse");

    }

    public void solveTriangle() {
        while(triangleChanged) {
            triangleChanged = false;
            calcLegA();
            calcLegB();
            calcHypot();
            calcTheta();
            calcDeta();
        }
    }

    public double calcLegA() {
        if(aSolved == false) {
            if (hypot > 0 && legB > 0) {
                legA = Math.sqrt((hypot * hypot) + (legB * legB));
                aSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return legA;
            }
            if (theta > 0 && legB > 0) {
                legA = legB / Math.tan(Math.toRadians(theta));
                aSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return legA;
            }
            if (theta > 0 && hypot > 0) {
                legA = Math.cos(Math.toRadians(theta)) * hypot;
                aSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return legA;
            }
            if (deta > 0 && hypot > 0) {
                legA = Math.sin(Math.toRadians(deta)) * hypot;
                aSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return legA;
            }
            if (deta > 0 && legB > 0) {
                legA = Math.tan(Math.toRadians(deta)) * legB;
                aSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return legA;
            }
            legA = Double.NaN;
        /*MAYBE*/
            return legA;
        }
        return Double.NaN;
    }

    public double calcLegB() {
        if (bSolved == false) {
            if (hypot > 0 && legA > 0) {
                legB = Math.sqrt((hypot * hypot) - (legA * legA));
                bSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return legB;
            }
            if (theta > 0 && hypot > 0) {
                legB = Math.sin(Math.toRadians(theta)) * hypot;
                bSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return legB;
            }
            if (theta > 0 && legA > 0) {
                legB = Math.tan(Math.toRadians(theta)) * legA;
                bSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return legB;
            }
            if (deta > 0 && hypot > 0) {
                legB = Math.cos(Math.toRadians(deta)) * hypot;
                bSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return legB;
            }
            if (legA > 0 && deta > 0) {
                legB = legA / Math.tan(Math.toRadians(deta));
                bSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return legB;
            }
            legB = Double.NaN;
        /*MAYBE*/
            return legB;
        }
        return Double.NaN;
    }

    public double calcHypot() {
        if(hypotSolved == false) {
            if (legA > 0 && legB > 0) {
                hypot = Math.sqrt((legA * legA) + (legB * legB));
                hypotSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return hypot;
            }
            if (legA > 0 && theta > 0) {
                hypot = legA / Math.cos(Math.toRadians(theta));
                hypotSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return hypot;
            }
            if (legB > 0 && deta > 0) {
                hypot = legB / Math.cos(Math.toRadians(deta));
                hypotSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return hypot;
            }
            if (legA > 0 && deta > 0) {
                hypot = legA / Math.sin(Math.toRadians(deta));
                hypotSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return hypot;
            }
            if (legB > 0 && theta > 0) {
                hypot = legB / Math.sin(Math.toRadians(theta));
                hypotSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return hypot;
            }
            hypot = Double.NaN;
        /*MAYBE*/
            return hypot;
        }
        return Double.NaN;
    }

    public double calcTheta() {
        if(thetaSolved == false) {
            if (legB > 0 && legA > 0) {
                theta = Math.toDegrees(Math.atan(legB / legA));
                thetaSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return theta;
            }
            if (legB > 0 && hypot > 0) {
                theta = Math.toDegrees(Math.asin(legB / hypot));
                thetaSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return hypot;
            }
            if (legA > 0 && hypot > 0) {
                theta = Math.toDegrees(Math.acos(legA / hypot));
                thetaSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return theta;
            }
            theta = Double.NaN;
        /*MAYBE*/
            return theta;
        }
        return Double.NaN;
    }

    public double calcDeta() {
        if (detaSolved == false) {
            if (legA > 0 && legB > 0) {
                deta = Math.toDegrees(Math.atan(legA / legB));
                detaSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return deta;
            }
            if (legB > 0 && hypot > 0) {
                deta = Math.toDegrees(Math.acos(legB / hypot));
                detaSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return deta;
            }
            if (legA > 0 && hypot > 0) {
                deta = Math.toDegrees(Math.asin(legA / hypot));
                detaSolved = true;
                triangleChanged = true;
            /*MAYBE*/
                return deta;
            }
            deta = Double.NaN;
        /*MAYBE*/
            return deta;
        }
        return Double.NaN;
    }

    public double getTheta() {
        return theta;
    }

    public double getDeta() {
        return deta;
    }

    public double getLegA() {
        return legA;
    }

    public double getLegB() {
        return legB;
    }

    public double getHypot() {
        return hypot;
    }
}
