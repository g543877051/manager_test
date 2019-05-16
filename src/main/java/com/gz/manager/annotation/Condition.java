package com.gz.manager.annotation;

import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public interface Condition {
	boolean matchs(ConditionContext conditionContext, AnnotatedTypeMetadata metadata);
}
