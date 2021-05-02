public class AngleBetweenHandsClock {
    public double angleClock(int hour, int minutes) {
        // 60 minutes, the minute hand covers 360 degree,  1 minute it covers 360/60 = 6 degree
        // 12 hours, the hour hand cover 360 degree,  1 hour it cover 360/12 = 30 degree
       //  in 1 hours (60 minutes) = 30 degree, 1 minute = 0.5 degree
        // result = minuteDegree - hourdegree
        // min of(result,360-result)
        int angle = Math.abs( minutes*(360/60) -( hour*(360/12)+ minutes*(30/60)));
        return Math.min(angle, 360-angle);
    }
}
