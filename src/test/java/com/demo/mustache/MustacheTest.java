package com.demo.mustache;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Just some code samples.
 */
public class MustacheTest {

  private static final Logger logger = LoggerFactory.getLogger(MustacheTest.class);

  @Test
  public void simpleMustacheTemplateTest() throws IOException {

    MustacheFactory mf = new DefaultMustacheFactory();
    Mustache m = mf.compile("test.simple.template.mustache");

    SomeDto todo = new SomeDto("Title 1", "Description");
    StringWriter writer = new StringWriter();
    m.execute(writer, todo).flush();
    String html = writer.toString();
    logger.info("html = {}", html);
  }


  public class SomeDto {
    private String title;
    private String text;
    private boolean done;
    private Date createdOn;
    private Date completedOn;

    SomeDto(final String title, final String text) {
      this.title = title;
      this.text = text;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public String getText() {
      return text;
    }

    public void setText(String text) {
      this.text = text;
    }

    public boolean isDone() {
      return done;
    }

    public void setDone(boolean done) {
      this.done = done;
    }

    public Date getCreatedOn() {
      return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
      this.createdOn = createdOn;
    }

    public Date getCompletedOn() {
      return completedOn;
    }

    public void setCompletedOn(Date completedOn) {
      this.completedOn = completedOn;
    }
  }



}
