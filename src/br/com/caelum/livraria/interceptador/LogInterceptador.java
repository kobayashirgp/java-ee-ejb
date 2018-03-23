package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {

	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception{
		long millis = System.currentTimeMillis();
		
		//chamada do metodo do dao
		Object o = context.proceed();
		context.proceed();
		
		String metodo = context.getMethod().getName();
		String nomeClasse = context.getTarget().getClass().getSimpleName();
		System.out.println(nomeClasse +" : "+metodo);
		System.out.println("Tempo gasto: "  + (System.currentTimeMillis() - millis) );
		
		return o;
	}
}
