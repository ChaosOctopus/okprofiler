package com.yangping.profiler.form;

import com.yangping.profiler.data.DebugDevice;
import com.yangping.profiler.data.DebugProcess;

import javax.swing.*;

public class OKProfiler {
    private JPanel shell;
    private JComboBox<DebugDevice> deviceList;
    private JComboBox<DebugProcess> appList;
    private JPanel buttonContainer;
    private JPanel mainContainer;
    private JEditorPane initialHtml;

    public OKProfiler() {
    }

    public JPanel getShell(){
        return shell;
    }

    public JComboBox<DebugProcess> getAppList() {
        return appList;
    }

    public JComboBox<DebugDevice> getDeviceList() {
        return deviceList;
    }

    public JPanel getMainContainer() {
        return mainContainer;
    }
}
