package br.com.edu.unit_tests.rent.utils;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	/**
	 * Retorna a data enviada por parametro com a adição dos dias desejado
	 * 	a Data pode estar no futuro (dias > 0) ou no passado (dias < 0)
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDaysTo(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(DAY_OF_MONTH, days);
		return calendar.getTime();
	}
	
	/**
	 * Retorna a data atual com a diferenca de dias enviados por parametro
	 * 		a Data pode estar no futuro (parametro positivo) ou no passado (parametro negativo)
	 * 
	 * @param days Quantidade de dias a ser incrementado/decrementado
	 * @return Data atualizada
	 */
	public static Date todayPlus(int days) {
		return addDaysTo(new Date(), days);
	}
	
	/**
	 * Retorna uma instância de <code>Date</code> refletindo os valores passados por parametro
	 * 
	 * @param dia
	 * @param mes
	 * @param ano
	 * @return
	 */
	public static Date getDate(int dia, int mes, int ano){
		Calendar calendar = Calendar.getInstance();
		calendar.set(DAY_OF_MONTH, dia);
		calendar.set(MONTH, mes - 1);
		calendar.set(YEAR, ano);
		return calendar.getTime();
	}
	
	/**
	 * Verifica se uma data é igual a outra
	 * 	Esta comparação considera apenas dia, mes e ano
	 * 
	 * @param one
	 * @param another
	 * @return
	 */
	public static boolean areSame(Date one, Date another) {
		Calendar oneCalendar = Calendar.getInstance();
		oneCalendar.setTime(one);
		Calendar anotherCalendar = Calendar.getInstance();
		anotherCalendar.setTime(another);
		return (oneCalendar.get(DAY_OF_MONTH) == anotherCalendar.get(DAY_OF_MONTH))
				&& (oneCalendar.get(MONTH) == anotherCalendar.get(MONTH))
				&& (oneCalendar.get(YEAR) == anotherCalendar.get(YEAR));
	}
	
	/**
	 * Verifica se uma determinada data é o dia da semana desejado
	 * 
	 * @param date Data a ser avaliada
	 * @param dayOfWeek <code>true</code> caso seja o dia da semana desejado, <code>false</code> em caso contrário
	 * @return
	 */
	public static boolean verifyIfIs(Date date, int dayOfWeek) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(DAY_OF_WEEK) == dayOfWeek;
	}
}
