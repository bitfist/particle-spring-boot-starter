package io.github.bitfist.particle.spring.window;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.Nullable;

@ConfigurationProperties("particle.window")
public class ParticleWindowProperties {

    private final String title;
    @Nullable
    private final String iconUrl;
    @Nullable
    private final Integer minimumWidth;
    @Nullable
    private final Integer minimumHeight;
    @Nullable
    private final Integer maximumWidth;
    @Nullable
    private final Integer maximumHeight ;
    private final boolean maximized;

    public ParticleWindowProperties(
            @Value("${particle.window.title}") String title,
            @Value("${particle.window.icon-url}") @Nullable String iconUrl,
            @Value("${particle.window.minimum-width}") @Nullable Integer minimumWidth,
            @Value("${particle.window.minimum-height}") @Nullable Integer minimumHeight,
            @Value("${particle.window.maximum-width}")@Nullable Integer maximumWidth,
            @Value("${particle.window.maximum-height}") @Nullable Integer maximumHeight,
            @Value("${particle.window.maximized}") boolean maximized
    ) {
        this.title = title;
        this.iconUrl = iconUrl;
        this.minimumWidth = minimumWidth;
        this.minimumHeight = minimumHeight;
        this.maximumWidth = maximumWidth;
        this.maximumHeight = maximumHeight;
        this.maximized = maximized;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    @Nullable
    public String getIconUrl() {
        return iconUrl;
    }

    @Nullable
    public Integer getMinimumWidth() {
        return minimumWidth;
    }

    @Nullable
    public Integer getMinimumHeight() {
        return minimumHeight;
    }

    @Nullable
    public Integer getMaximumWidth() {
        return maximumWidth;
    }

    @Nullable
    public Integer getMaximumHeight() {
        return maximumHeight;
    }

    public boolean isMaximized() {
        return maximized;
    }

}
