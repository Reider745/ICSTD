package ru.koshakmine.icstd.v1.ui.elements;

import org.mozilla.javascript.ScriptableObject;

public class ScaleElement extends WindowElementSize {
    protected String bitmap;
    protected int direction = 0;
    protected boolean invert = false;

    public ScaleElement(String bitmap, float x, float y, int width, int height) {
        super("scale", x, y, width, height);

        this.bitmap = bitmap;
    }

    public ScaleElement(String bitmap, float x, float y, float scale) {
        super("scale", x, y, scale);

        this.bitmap = bitmap;
    }

    public ScaleElement setDirection(int direction) {
        this.direction = direction;
        return this;
    }

    public ScaleElement setInvert(boolean invert) {
        this.invert = invert;
        return this;
    }

    @Override
    public ScriptableObject toElement() {
        final ScriptableObject desc = super.toElement();

        desc.put("bitmap", desc, bitmap);
        desc.put("direction", desc, direction);
        desc.put("invert", desc, invert);

        return desc;
    }
}
