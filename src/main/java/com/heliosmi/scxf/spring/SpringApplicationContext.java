/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.heliosmi.scxf.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.heliosmi.scxf.aspect.LoggingAspect;
import com.heliosmi.scxf.webservice.HelloWorldWS;

/**
 * Class to provide access to Spring application context. Spring bean can be
 * pulled out of <code>applicationContext</code>.
 * 
 * @author Saurabh Maheshwari
 * 
 */
@Component
public class SpringApplicationContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	/**
	 * Returns a bean from application-context.
	 * <p> Wrapper method for <code>getBean</code> from {@link BeanFactory} to
	 * minimize typing.</p>
	 * 
	 * @return an instance of the single bean matching the required type
	 */
	public static <T> T getBean(Class<T> requiredType) {
		return applicationContext.getBean(requiredType);
	}
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringApplicationContext.applicationContext = applicationContext;
	}	
}
