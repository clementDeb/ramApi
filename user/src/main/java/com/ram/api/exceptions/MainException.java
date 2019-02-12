package com.ram.api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@AllArgsConstructor
@Getter
public class MainException extends Throwable {

	private String msg;

}
