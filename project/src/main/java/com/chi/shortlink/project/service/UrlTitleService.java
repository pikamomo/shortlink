package com.chi.shortlink.project.service;

/**
 * URL Title Interface Layer
 *
 */
public interface UrlTitleService {

    /**
     * Get title by URL
     *
     * @param url Target website address
     * @return Website title
     */
    String getTitleByUrl(String url);
}