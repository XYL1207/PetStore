import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.security.GeneralSecurityException;

public class Gui {

    public void createWindow() throws GeneralSecurityException, MessagingException {
        Stocks stock = new GetData().getdatas("http://hq.sinajs.cn/list=sz002307");

        JFrame jf = new JFrame("股票监控");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 创建内容面板，使用边界布局
        JPanel panel = new JPanel(new BorderLayout());

        // 表头（列名）
        Object[] columnNames = {"股票编号", "股票名称", "当前价格", "涨跌百分比", "涨跌幅"};

        // 表格所有行数据
        Object[][] rowData = {
                {stock.getCode(), stock.getName(), stock.getCorrentPrice(), stock.getYestoOpenprice(), stock.getRate()},
        };

        // 创建一个表格，指定 所有行数据 和 表头
        JTable table = new JTable(rowData, columnNames);

        // 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        // 把 表格内容 添加到容器中心
        panel.add(table, BorderLayout.CENTER);

        jf.setContentPane(panel);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

        if(Math.abs(stock.getRate())<=5){ //当股票的涨跌百分比在5之间时发送邮件预警
            SendMessages sendMail = new SendMessages();
            sendMail.sendMessages(stock);
        }
    }

}
