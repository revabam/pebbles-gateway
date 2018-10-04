package com.revature.gatewayservice.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

@Configuration
public class HystrixFallbackConfiguration {

	/**
	 * Fallback response for curriculum service
	 * 
	 * @return FallbackProvider
	 * @author Alicia Douglas | Nisat Chowdhury | Spark1806-USF-Java | Steven Kelsey
	 */
	@Bean
	public FallbackProvider curriculumFallbackProvider() {
		return new FallbackProvider() {

			@Override
			public String getRoute() {
				return "pebbles-curriculum";
			}


			@Override
			public ClientHttpResponse fallbackResponse(Throwable cause) {
				return new ClientHttpResponse() {

					@Override
					public HttpHeaders getHeaders() {
						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_JSON);
						return headers;
					}

					@Override
					public InputStream getBody() throws IOException {
						return new ByteArrayInputStream(
								"{\"message\":\"Sorry, Curriculum Service is Down!\"}".getBytes());
					}

					@Override
					public String getStatusText() throws IOException {
						return HttpStatus.SERVICE_UNAVAILABLE.toString();
					}

					@Override
					public HttpStatus getStatusCode() throws IOException {
						return HttpStatus.SERVICE_UNAVAILABLE;
					}

					@Override
					public int getRawStatusCode() throws IOException {
						return HttpStatus.SERVICE_UNAVAILABLE.value();
					}

					@Override
					public void close() {
					}
				};
			}

			@Override
			public ClientHttpResponse fallbackResponse() {
				return null;
			}
		};
	}
	
	
	/**
	 * Fallback response for batch service
	 * 
	 * @return FallbackProvider
	 * @author Alicia Douglas | Nisat Chowdhury | Spark1806-USF-Java | Steven Kelsey
	 */
	@Bean
	public FallbackProvider batchFallbackProvider() {
		return new FallbackProvider() {

			@Override
			public String getRoute() {
				return "pebbles-batch";
			}


			@Override
			public ClientHttpResponse fallbackResponse(Throwable cause) {
				return new ClientHttpResponse() {

					@Override
					public HttpHeaders getHeaders() {
						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_JSON);
						return headers;
					}

					@Override
					public InputStream getBody() throws IOException {
						return new ByteArrayInputStream(
								"{\"message\":\"Sorry, Batch Service is Down!\"}".getBytes());
					}

					@Override
					public String getStatusText() throws IOException {
						return HttpStatus.SERVICE_UNAVAILABLE.toString();
					}

					@Override
					public HttpStatus getStatusCode() throws IOException {
						return HttpStatus.SERVICE_UNAVAILABLE;
					}

					@Override
					public int getRawStatusCode() throws IOException {
						return HttpStatus.SERVICE_UNAVAILABLE.value();
					}

					@Override
					public void close() {
					}
				};
			}

			@Override
			public ClientHttpResponse fallbackResponse() {
				return null;
			}
		};
	}
	
	/**
	 * Fallback response for calendar service
	 * 
	 * @return FallbackProvider
	 * @author Alicia Douglas | Nisat Chowdhury | Spark1806-USF-Java | Steven Kelsey
	 */
	@Bean
	public FallbackProvider calendarFallbackProvider() {
		return new FallbackProvider() {

			@Override
			public String getRoute() {
				return "pebbles-calendar";
			}


			@Override
			public ClientHttpResponse fallbackResponse(Throwable cause) {
				return new ClientHttpResponse() {

					@Override
					public HttpHeaders getHeaders() {
						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_JSON);
						return headers;
					}

					@Override
					public InputStream getBody() throws IOException {
						return new ByteArrayInputStream(
								"{\"message\":\"Sorry, Calendar Service is Down!\"}".getBytes());
					}

					@Override
					public String getStatusText() throws IOException {
						return HttpStatus.SERVICE_UNAVAILABLE.toString();
					}

					@Override
					public HttpStatus getStatusCode() throws IOException {
						return HttpStatus.SERVICE_UNAVAILABLE;
					}

					@Override
					public int getRawStatusCode() throws IOException {
						return HttpStatus.SERVICE_UNAVAILABLE.value();
					}

					@Override
					public void close() {
					}
				};
			}

			@Override
			public ClientHttpResponse fallbackResponse() {
				return null;
			}
		};
	}
	
}
