package ru.koshakmine.icstd.v1.ui.type;

public interface IWindow {
    void open();
    void close();
    boolean isOpened();
    com.zhekasmirnov.innercore.api.mod.ui.window.IWindow getWindow();
}
