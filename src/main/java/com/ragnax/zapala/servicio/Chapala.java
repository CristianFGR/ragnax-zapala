package com.ragnax.zapala.servicio;

import java.sql.Timestamp;

import com.ragnax.domain.zapala.modelo.Zapala;
import com.ragnax.domain.zapala.modelo.ZapalaRequest;
import com.ragnax.zapala.exception.ZapalaImplException;

public interface Chapala {

	public Zapala generarTiempoDuracion(ZapalaRequest zapalaRequest) throws ZapalaImplException;
	
	public Timestamp convertirStrFechaConFormatToTimestamp(ZapalaRequest zapalaRequest) throws ZapalaImplException;
	
	public boolean isValidDate(ZapalaRequest zapalaRequest) throws ZapalaImplException;
	
	public boolean validarPatronEmail(ZapalaRequest zapalaRequest) throws ZapalaImplException;
	
	public Zapala generarPatronRUT(ZapalaRequest zapalaRequest) throws ZapalaImplException;
	
	public Zapala generarCodigoByNumeroByEncodear (ZapalaRequest zapalaRequest) throws ZapalaImplException;
	
	public Zapala generarCodigoByNumero(ZapalaRequest zapalaRequest) throws ZapalaImplException;
	
	public Zapala generarMD5(ZapalaRequest zapalaRequest)  throws ZapalaImplException;
	
	public <T> Zapala generacionSHA(T content, Class<T> typeRequest);
	
	public <T> Zapala generacionSHA(ZapalaRequest zapalaRequest) throws ZapalaImplException;
}
