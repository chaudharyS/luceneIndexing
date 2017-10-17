/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghazalsearch;

/**
 *
 * @author yetItCompiles
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.store.FSDirectory;
public class indexing {
    public static void main(String[] args) throws IOException, ParseException {
        readingXML yo = new readingXML();
        int lastFile = 100;
        String indexDirectory = "C:\\ghazal";
        StandardAnalyzer analyzer = new StandardAnalyzer();
        FSDirectory index = FSDirectory.open(Paths.get(indexDirectory));
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter w = new IndexWriter(index, config);
        List<Document> documents = new ArrayList<>();
        for(int fileCount=1;fileCount<=lastFile;fileCount++){
            String filePath = "D:\\solution\\Ghazal B-Z\\Ghazal-" + String.format("%05d", fileCount) + ".xml";
            File xmlFile = new File(filePath);
            String shayar = yo.getShayar(xmlFile);
            String title = yo.getTitle(xmlFile);
            String content = yo.getContent(xmlFile);
            documents.add(createDoc(w, shayar, title, content));
            System.out.println("File "+fileCount+ " Indexed");
        }
        w.deleteAll();
        w.addDocuments(documents);
        w.commit();
        w.close();
    }
    private static Document createDoc (IndexWriter w, String shayar, String title, String content){
        Document doc = new Document();
        System.out.println(title);
        doc.add(new TextField("content", content, Field.Store.YES));
        doc.add(new StringField("shayar", shayar, Field.Store.YES));
        doc.add(new StringField("title", title, Field.Store.YES));
        return doc;
    }
}
