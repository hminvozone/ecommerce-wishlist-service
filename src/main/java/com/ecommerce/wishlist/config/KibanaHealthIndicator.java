package com.ecommerce.wishlist.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class KibanaHealthIndicator implements HealthIndicator {

    private static final Logger logger = LoggerFactory.getLogger(KibanaHealthIndicator.class);

    private static final String MARK_KIBANA = "MARK_KIBANA";

    /*
     * (non-Javadoc)
     * @see org.springframework.boot.actuate.health.HealthIndicator#health()
     */
    @Override
    public Health health() {
        final Marker kibanaMarker = MarkerFactory.getMarker("KIBANA");
        logger.info(kibanaMarker, MARK_KIBANA);
        return Health.up().build();
    }
}
