package com.nt.company1;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SleepTime {
 private LocalDateTime stime;
 private LocalDateTime etime;
 private int duration;
public LocalDateTime getStime() {
	return stime;
}
public LocalDateTime getEtime() {
	return etime;
}
public int getDuration() {
	return duration;
}
public SleepTime(LocalDateTime stime, LocalDateTime etime) {
	this.stime = stime;
	this.etime = etime;
	this.duration = durationTime();
}

public void setEtime(LocalDateTime etime) {
	this.etime = etime;
}
public void setDuration(int duration) {
	this.duration = duration;
}
@Override
public String toString() {
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yy HH:mm");
	return stime.format(format)+"   "+etime.format(format)+"  "+duration;
}
public int durationTime()
{
	long s1=Timestamp.valueOf(stime).getTime();
	long s2=Timestamp.valueOf(etime).getTime();
	return (int)(s2-s1)/(60*1000);
}

 
}
