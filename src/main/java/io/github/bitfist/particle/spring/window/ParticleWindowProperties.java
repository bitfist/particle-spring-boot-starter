package io.github.bitfist.particle.spring.window;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.Nullable;

@ConfigurationProperties("particle.window")
public class ParticleWindowProperties {

    @Nullable
    private String title = null;
    @Nullable
    private String iconURL = null;
    @Nullable
    private Integer minimumWidth = null;
    @Nullable
    private Integer minimumHeight = null;
    @Nullable
    private Integer maximumWidth = null;
    @Nullable
    private Integer maximumHeight = null;
    private boolean maximized = false;

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Nullable
    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    @Nullable
    public Integer getMinimumWidth() {
        return minimumWidth;
    }

    public void setMinimumWidth(Integer minimumWidth) {
        this.minimumWidth = minimumWidth;
    }

    @Nullable
    public Integer getMinimumHeight() {
        return minimumHeight;
    }

    public void setMinimumHeight(Integer minimumHeight) {
        this.minimumHeight = minimumHeight;
    }

    @Nullable
    public Integer getMaximumWidth() {
        return maximumWidth;
    }

    public void setMaximumWidth(Integer maximumWidth) {
        this.maximumWidth = maximumWidth;
    }

    @Nullable
    public Integer getMaximumHeight() {
        return maximumHeight;
    }

    public void setMaximumHeight(Integer maximumHeight) {
        this.maximumHeight = maximumHeight;
    }

    public boolean isMaximized() {
        return maximized;
    }

    public void setMaximized(boolean maximized) {
        this.maximized = maximized;
    }
}
