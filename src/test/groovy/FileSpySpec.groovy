import spock.lang.Specification

class FileSpySpec extends Specification {
    def 'file spy example' () {
        given:
        def mockFile = Mock(File)
        GroovySpy(File, global: true, useObjenesis: true)
        when:
        def file = new File('testdir', 'testfile')
        file.delete()
        then :
        1 * new File('testdir','testfile') >> { mockFile }
        1 * mockFile.delete()
    }
}
