package com.ragnax.zapala.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

import com.ragnax.zapala.controller.modelo.RagnaxError;
import com.ragnax.zapala.controller.modelo.Zapala;
import com.ragnax.zapala.controller.modelo.ZapalaRequest;
import com.ragnax.zapala.exception.ZapalaImplException;
import com.ragnax.zapala.servicio.Chapala;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.http.MediaType;

@RestController
public class ZapalaController {
	
	Logger logger  = LoggerFactory.getLogger(ZapalaController.class);
	
	@Autowired
	Chapala chapala;
	
//	@Value("${configuracion.texto}")
//	private String texto;
	/***************************************************/
	/*************** generarTiempoDuracion *** *******************/
	/***************************************************/
	@ApiOperation(value = "prueba", response = Zapala.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de creacion", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Zapala.class)
	})
	@GetMapping(value = "${servicio.app.uri.prueba}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String>  prueba( @ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") 
	@PathVariable String idprueba)  throws ZapalaImplException{
//	@PostMapping(value = "${servicio.app.uri.generarTiempoDuracion}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Zapala>  generarTiempoDuracion()  throws ZapalaImplException{
		
		return new ResponseEntity<>(idprueba, HttpStatus.OK);
		//return new ResponseEntity<>(new Zapala(texto), HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "generarTiempoDuracion", response = Zapala.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de creacion", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Zapala.class)
	})
	@PostMapping(value = "${servicio.app.uri.generarTiempoDuracion}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Zapala>  generarTiempoDuracion( @ApiParam(value = "objeto de entrada", required = true)
	@RequestBody @Valid ZapalaRequest zapalaRequest, @ApiIgnore Errors errors)  throws ZapalaImplException{
//	@PostMapping(value = "${servicio.app.uri.generarTiempoDuracion}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Zapala>  generarTiempoDuracion()  throws ZapalaImplException{
		
		return new ResponseEntity<>(chapala.generarTiempoDuracion(zapalaRequest), HttpStatus.OK);
		//return new ResponseEntity<>(new Zapala(texto), HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "convertirStrFechaConFormatToTimestamp", response = Zapala.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de creacion", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Zapala.class)
	})
	@PostMapping(value = "${servicio.app.uri.convertirStrFechaConFormatToTimestamp}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Zapala>  convertirStrFechaConFormatToTimestamp( @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid ZapalaRequest zapalaRequest, @ApiIgnore Errors errors)  throws ZapalaImplException{
//		System.out.println(textoValue);
		
		return new ResponseEntity<>(new Zapala(chapala.convertirStrFechaConFormatToTimestamp(zapalaRequest)),
	              HttpStatus.OK);
	}
	
	@ApiOperation(value = "generarCodigoByNumero", response = Zapala.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de creacion", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Zapala.class)
	})
	@PostMapping(value = "${servicio.app.uri.generarCodigoByNumero}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Zapala>  generarCodigoByNumero( @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid ZapalaRequest zapalaRequest, @ApiIgnore Errors errors)  throws ZapalaImplException{
//		System.out.println(textoValue);
		
		return new ResponseEntity<>(chapala.generarCodigoByNumero(
				zapalaRequest), HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "generarCodigoByNumeroByEncodear", response = Zapala.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de creacion", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Zapala.class)
	})
	@PostMapping(value = "${servicio.app.uri.generarCodigoByNumeroByEncodear}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Zapala>  generarCodigoByNumeroByEncodear( @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid ZapalaRequest zapalaRequest, @ApiIgnore Errors errors)  throws ZapalaImplException{
//		System.out.println(textoValue);
		
		return new ResponseEntity<>(chapala.generarCodigoByNumeroByEncodear(
				zapalaRequest), HttpStatus.OK);
	}
	
	@ApiOperation(value = "generarPatronRUT", response = Zapala.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de creacion", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Zapala.class)
	})
	@PostMapping(value = "${servicio.app.uri.generarPatronRUT}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Zapala>  generarPatronRUT( @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid ZapalaRequest zapalaRequest, @ApiIgnore Errors errors)  throws ZapalaImplException{
//		System.out.println(textoValue);
		
		return new ResponseEntity<>(chapala.generarPatronRUT(
				zapalaRequest), HttpStatus.OK);
	}
	
}
