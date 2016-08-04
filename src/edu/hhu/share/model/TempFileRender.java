package edu.hhu.share.model;

import java.io.File;

import com.jfinal.render.FileRender;

public class TempFileRender extends FileRender {
	  private String fileName;
	  private File file;
	  public TempFileRender(String fileName) {
	      super(fileName);
	      this.fileName = fileName;
	  }

	  public TempFileRender(File file) {
	      super(file);
	      this.file = file;
	  }

	  @Override
	  public void render() {
	      try {
	          super.render();
	      } finally {

	          if(null != fileName) {
	              file = new File(fileName);
	          }

	          if(null != file) {
	              file.delete();
	              file.deleteOnExit();
	          }
	      }
	  }
	}
