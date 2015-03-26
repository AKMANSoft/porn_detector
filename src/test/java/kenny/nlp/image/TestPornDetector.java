package kenny.nlp.image;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by kenny on 3/26/15.
 */
public class TestPornDetector {

    private static final SkinTonePornDetector SKIN_TONE_AVG_PORN_DETECTOR = new SkinToneAveragedPornDetector();

    private static final SkinTonePornDetector SKIN_TONE_SPANNING_PORN_DETECTOR = new SkinToneSpanningPornDetector();

    @Test
    public void testSpanningSkinToneClassifier() throws IOException {
        SKIN_TONE_SPANNING_PORN_DETECTOR.setIsPornDelta(5);
        System.out.println("porn:");
        runTest("corpus/image/porn/2.jpg");
        runTest("corpus/image/porn/04_6231.jpg");
        runTest("corpus/image/porn/6e5b26_three_vibrators.jpg");
        runTest("corpus/image/porn/08_4395.jpg");
        runTest("corpus/image/porn/c484ee2b4eb7f4f56f7335b2f323c389.jpg");
        runTest("corpus/image/porn/davina_3.jpg");
        runTest("corpus/image/porn/Screen Shot 2014-07-19 at 5.19.41 PM.png");
        runTest("corpus/image/porn/Screen Shot 2015-02-02 at 12.37.13 AM.png");
        runTest("corpus/image/porn/sexy-teen-and-milf-fuck-a-big-black-cock2.jpg");
        runTest("corpus/image/porn/sexy-teen-and-milf-fuck-a-big-black-cock6.jpg");
        runTest("corpus/image/porn/sexy-teen-and-milf-fuck-a-big-black-cock8.jpg");
        runTest("corpus/image/porn/wpid-sex-6889.jpg");
        runTest("corpus/image/porn/wpid-sex-9888.jpg");

        System.out.println("safe:");
        runTest("corpus/image/safe/1378164_1431489890411367_1698932421_n.jpg");
        runTest("corpus/image/safe/1460236_10100876354196167_1793762466_n.jpg");
        runTest("corpus/image/safe/1644987.jpg");
        runTest("corpus/image/safe/face.jpg");
        runTest("corpus/image/safe/image.jpeg");
        runTest("corpus/image/safe/img-thing.jpg");
        runTest("corpus/image/safe/Military-Fighter-Jet.jpg");
        runTest("corpus/image/safe/money4.jpg");
        runTest("corpus/image/safe/samus_artwork_8.jpg");
        runTest("corpus/image/safe/whale80.png");
        runTest("corpus/image/safe/yoshi.png");
    }

    @Test
    public void testAveragedSkinToneClassifier() throws IOException {
        SKIN_TONE_AVG_PORN_DETECTOR.setIsPornDelta(30);
        System.out.println("porn:");
        runTest2("corpus/image/porn/2.jpg");
        runTest2("corpus/image/porn/04_6231.jpg");
        runTest2("corpus/image/porn/6e5b26_three_vibrators.jpg");
        runTest2("corpus/image/porn/08_4395.jpg");
        runTest2("corpus/image/porn/c484ee2b4eb7f4f56f7335b2f323c389.jpg");
        runTest2("corpus/image/porn/davina_3.jpg");
        runTest2("corpus/image/porn/Screen Shot 2014-07-19 at 5.19.41 PM.png");
        runTest2("corpus/image/porn/Screen Shot 2015-02-02 at 12.37.13 AM.png");
        runTest2("corpus/image/porn/sexy-teen-and-milf-fuck-a-big-black-cock2.jpg");
        runTest2("corpus/image/porn/sexy-teen-and-milf-fuck-a-big-black-cock6.jpg");
        runTest2("corpus/image/porn/sexy-teen-and-milf-fuck-a-big-black-cock8.jpg");
        runTest2("corpus/image/porn/wpid-sex-6889.jpg");
        runTest2("corpus/image/porn/wpid-sex-9888.jpg");

        System.out.println("safe:");
        runTest2("corpus/image/safe/1378164_1431489890411367_1698932421_n.jpg");
        runTest2("corpus/image/safe/1460236_10100876354196167_1793762466_n.jpg");
        runTest2("corpus/image/safe/1644987.jpg");
        runTest2("corpus/image/safe/face.jpg");
        runTest2("corpus/image/safe/image.jpeg");
        runTest2("corpus/image/safe/img-thing.jpg");
        runTest2("corpus/image/safe/Military-Fighter-Jet.jpg");
        runTest2("corpus/image/safe/money4.jpg");
        runTest2("corpus/image/safe/samus_artwork_8.jpg");
        runTest2("corpus/image/safe/whale80.png");
        runTest2("corpus/image/safe/yoshi.png");
    }

    private void runTest(final String resource) throws IOException {
        System.out.println(SKIN_TONE_SPANNING_PORN_DETECTOR.isPorn(getStream(resource)) + "\t" + resource);
    }

    private void runTest2(final String resource) throws IOException {
        System.out.println(SKIN_TONE_AVG_PORN_DETECTOR.isPorn(getStream(resource)) + "\t" + resource);
    }

    private InputStream getStream(final String resource) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
    }
}
