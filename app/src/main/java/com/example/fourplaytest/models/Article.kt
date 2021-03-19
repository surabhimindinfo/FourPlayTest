package com.example.fourplaytest.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

public class Article  {
    @SerializedName("source")
    @Expose
    private var source: Source? = null

    @SerializedName("author")
    @Expose
    private var author: String? = null

    @SerializedName("title")
    @Expose
    private var title: String? = null

    @SerializedName("description")
    @Expose
    private var description: String? = null

    @SerializedName("url")
    @Expose
    private var url: String? = null

    @SerializedName("urlToImage")
    @Expose
    private var urlToImage: String? = null

    @SerializedName("publishedAt")
    @Expose
    private var publishedAt: String? = null

    @SerializedName("content")
    @Expose
    private var content: String? = null

    fun getSource(): Source? {
        return source
    }


    fun getAuthor(): String? {
        return author
    }

    fun setAuthor(author: String?) {
        this.author = author
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getDescription(): String? {
        return description
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String?) {
        this.url = url
    }

    fun getUrlToImage(): String? {
        return urlToImage
    }

    fun setUrlToImage(urlToImage: String?) {
        this.urlToImage = urlToImage
    }

    fun getPublishedAt(): String? {
        return publishedAt
    }

    fun setPublishedAt(publishedAt: String?) {
        this.publishedAt = publishedAt
    }

    fun getContent(): String? {
        return content
    }

    fun setContent(content: String?) {
        this.content = content
    }
}

class Source
{
    @SerializedName("id")
    @Expose
    private var id: String? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null

    fun getId(): String? {
        return id
    }

    fun setId(id: String?) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

}