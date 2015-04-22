package j2html.src.tags;

import java.util.ArrayList;
import j2html.src.attributes.Attribute;

public abstract class BaseTag {

    protected String tag;
    protected ArrayList<Attribute> attributes;
    protected BaseTag parent;

    protected BaseTag(String tagType) {
        this.tag = tagType;
        this.attributes = new ArrayList<Attribute>();
    }

    public void setParent(BaseTag parent) {
        this.parent = parent;
    }

    /**
     * Sets an attribute on an element
     * @param name  the attribute
     * @param value the attribute value
     */
    public void setAttribute(String name, String value) {
        if (value != null) {
            for (Attribute attribute : attributes) {
                if (attribute.getName().equals(name)) {
                    //if attribute exists we set the attribute value in stead of just adding a new attribute
                    attribute.setValue(value);
                    return;
                }
            }
            attributes.add(new Attribute(name, value));
        } else {
            attributes.add(new Attribute(name));
        }
    }

    public String render() {
        return openTag() + closeTag();
    }

    @Override
    public String toString() {
        return this.render();
    }

    protected String openTag() {
        StringBuilder b = new StringBuilder("<");
        b.append(tag);
        for (Attribute attr : attributes) {
            b.append(attr.render());
        }
        b.append(">");
        return b.toString();
    }

    protected String closeTag() {
        return "</" + tag + ">";
    }

}
