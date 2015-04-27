package j2html.src.tags;

public class UnescapedText extends Tag {

    public UnescapedText(String text) {
        super(text);
    }

    @Override
    public String render(){
        return tag;
    }

    @Override
    public String toString(){
        return this.render();
    }

}
