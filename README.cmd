
PartyMassWorkListView

ͨ��ListView��ǶViewPager��GrideView�����˻�����ͻ���⣬��ʵ���������ؼ������廬��Ч������ʵ��ViewPager��Ƕ������г�����ҳ���������������������Ҳ������Viewpager
�·�ָʾ��������ָʾ�㲻ˢ�µ����⣬����һ���鿴����ֻ�е�ListView�������»���֮��ViewPagerָʾ���Ż�ˢ�£�ͨ��һ��ʱ���������������ڳ¹�����˸����⡣
��������ViewPager��Adapter��pageListenner��getView�н����˶�γ�ʼ����������ֻ���ڱ�Ҫʱ����һ�γ�ʼ�����ɣ���˿��Խ����ƶ���convertViewΪnullʱ���еĲ����м��ɣ�
��һ����������onPageSelected���������ú�ָʾ����ʾ���ݺ���ͨ��notifyDataSetInvalidated������������ҳ���ػ棬�޸ĺ�����������֮��һ�оͶ������ˡ�

PartyMassWorkViewPagerGrideViewListView

����ViewPager��GrideView��listView�����ؼ�ʵ��ĳUI������ƣ���������������廬��Ч��ʱ��������������һ��ScrollView�������˻�����ͻ���⣬
���и��ؼ�������������ListView��GrideView�ֱ���ʾ��ȫ��ͨ����дListView��GrideView��onMeasure�����趨�̶����ƴ�С����������ʾ��ȫ�����⣬
�������޷�ʵ�����廬��Ч�����ڴ��ڼ䳢�����Զ���ScrollView�����ⲿ���أ����⻬����ͻ��������Ч�����վ�����ָ��ͨ��ListView��ǶViewPager��
GrideViewʵ�����廬��Ч����ͨ������¼����ݻ�������ӦGrideView��ViewPager�ĵ���뻬�����ɹ�������⡣�ڴ˶�ĳ���ֱ�ʾ��л��
