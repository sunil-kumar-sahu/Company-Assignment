package com.nt.company2;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

import com.nt.company1.SleepTime;

public class Output {

	public static void main(String[] args) {
		ArrayList<SleepTime> al = new Output().insertData();
		new Output().sort(al);
		al = new Output().removeOverLapping(al);
		int sum=0;
		for (SleepTime st : al) {
			System.out.println(st);
			sum+=st.durationTime();
		}
		System.out.println(al.size());
		System.out.println(sum);
	}

	public ArrayList<SleepTime> insertData() {
		ArrayList<SleepTime> al = new ArrayList<>();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yy HH:mm");
		al.add(new SleepTime(LocalDateTime.parse("20-Jan-23 23:00", format),
				LocalDateTime.parse("20-Jan-23 23:15", format)));// 1
		al.add(new SleepTime(LocalDateTime.parse("20-Jan-23 23:00", format),
				LocalDateTime.parse("20-Jan-23 23:15", format)));// 2
		al.add(new SleepTime(LocalDateTime.parse("20-Jan-23 23:00", format),
				LocalDateTime.parse("20-Jan-23 23:15", format)));// 3
		al.add(new SleepTime(LocalDateTime.parse("20-Jan-23 23:20", format),
				LocalDateTime.parse("20-Jan-23 23:55", format)));// 4
		al.add(new SleepTime(LocalDateTime.parse("20-Jan-23 23:20", format),
				LocalDateTime.parse("20-Jan-23 23:55", format)));// 5
		al.add(new SleepTime(LocalDateTime.parse("20-Jan-23 23:55", format),
				LocalDateTime.parse("21-Jan-23 00:18", format)));// 6
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 00:20", format),
				LocalDateTime.parse("21-Jan-23 00:37", format)));// 7
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 00:20", format),
				LocalDateTime.parse("21-Jan-23 00:37", format)));// *7
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 00:38", format),
				LocalDateTime.parse("21-Jan-23 02:10", format)));// 8
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 00:38", format),
				LocalDateTime.parse("21-Jan-23 02:10", format)));// 9
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 00:38", format),
				LocalDateTime.parse("21-Jan-23 02:10", format)));// 10
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 00:38", format),
				LocalDateTime.parse("21-Jan-23 02:10", format)));// 11
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 02:10", format),
				LocalDateTime.parse("21-Jan-23 02:18", format)));// 12
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 02:22", format),
				LocalDateTime.parse("21-Jan-23 02:35", format)));// 13
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 02:36", format),
				LocalDateTime.parse("21-Jan-23 02:48", format)));// 14
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 02:36", format),
				LocalDateTime.parse("21-Jan-23 02:48", format)));// 15
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 02:48", format),
				LocalDateTime.parse("21-Jan-23 03:33", format)));// 16
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 02:48", format),
				LocalDateTime.parse("21-Jan-23 03:33", format)));// 18
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 02:20", format),
				LocalDateTime.parse("21-Jan-23 03:35", format)));// 19
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 02:20", format),
				LocalDateTime.parse("21-Jan-23 03:35", format)));// 20
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 03:36", format),
				LocalDateTime.parse("21-Jan-23 03:49", format)));// 21
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 03:49", format),
				LocalDateTime.parse("21-Jan-23 04:12", format)));// 22
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 03:49", format),
				LocalDateTime.parse("21-Jan-23 04:12", format)));// 23
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 04:12", format),
				LocalDateTime.parse("21-Jan-23 04:42", format)));// 24
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 04:12", format),
				LocalDateTime.parse("21-Jan-23 04:42", format)));// 25
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 04:43", format),
				LocalDateTime.parse("21-Jan-23 05:05", format)));// 26
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 03:49", format),
				LocalDateTime.parse("21-Jan-23 05:15", format)));// 27
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 03:49", format),
				LocalDateTime.parse("21-Jan-23 05:15", format)));// 28
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 03:49", format),
				LocalDateTime.parse("21-Jan-23 05:35", format)));// 29
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 05:36", format),
				LocalDateTime.parse("21-Jan-23 06:10", format)));// 30
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 05:36", format),
				LocalDateTime.parse("21-Jan-23 06:10", format)));// 31
		al.add(new SleepTime(LocalDateTime.parse("21-Jan-23 06:10", format),
				LocalDateTime.parse("21-Jan-23 07:20", format)));// 32

		return al;
	}

	public ArrayList<SleepTime> removeOverLapping(ArrayList<SleepTime> al) {
		for (int i = 0; i < al.size(); i++) {
			for (int j = i + 1; j < al.size(); j++) {
				long d1 = java.sql.Timestamp.valueOf(al.get(i).getStime()).getTime();
				long d2 = java.sql.Timestamp.valueOf(al.get(j).getStime()).getTime();
				long d3 = java.sql.Timestamp.valueOf(al.get(i).getEtime()).getTime();
				long d4 = java.sql.Timestamp.valueOf(al.get(j).getEtime()).getTime();
				if (d1 <= d2 && d3 >= d4) {
					al.remove(j);
					j--;
				}
			
				else if(d1<=d2 && d3<=d4 && d2<=d3) 
				  { 
				  al.get(i).setEtime(al.get(j).getEtime());
				  al.remove(j);
				  al.get(i).setDuration((int)(Timestamp.valueOf(al.get(i).getEtime()).getTime() -Timestamp.valueOf(al.get(i).getStime()).getTime())/60000);
				  	j--; 
				  }
				 
			}
		}
		return al;
	}

	public void sort(ArrayList<SleepTime> al) {
		for (int i = 0; i < al.size(); i++) {
			for (int j = i + 1; j < al.size(); j++) {
				if (Timestamp.valueOf(al.get(i).getStime()).getTime() >= (Timestamp.valueOf(al.get(j).getStime()).getTime())) {
					Collections.swap(al, i, j);
				}
			}
		}
	}



}
