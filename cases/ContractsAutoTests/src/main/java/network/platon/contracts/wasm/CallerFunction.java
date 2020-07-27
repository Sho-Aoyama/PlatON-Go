package network.platon.contracts.wasm;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.WasmFunctionEncoder;
import org.web3j.abi.datatypes.WasmFunction;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.WasmContract;
import org.web3j.tx.gas.GasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the org.web3j.codegen.WasmFunctionWrapperGenerator in the 
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with platon-web3j version 0.13.0.6.
 */
public class CallerFunction extends WasmContract {
    private static String BINARY_0 = "0x0061736d01000000013d0b60027f7f0060017f0060017f017f60000060037f7f7f0060027f7f017f60047f7f7f7f006000017f60037f7f7f017f60047f7f7f7f017f60017f017e02710503656e760c706c61746f6e5f70616e6963000303656e760d706c61746f6e5f63616c6c6572000103656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000703656e7610706c61746f6e5f6765745f696e707574000103656e760d706c61746f6e5f72657475726e0000032726030101010100000402080006040005000104030209000201020a0005000200000403020303020405017001030305030100020608017f0141f08a040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f727300050f5f5f66756e63735f6f6e5f65786974002606696e766f6b6500170908010041010b0207070aa040261f0041bc08420037020041c408410036020041bc08100641011008102810290b2201017f03402001410c470440200020016a4100360200200141046a21010c010b0b0b0300010b940101027f41c808410136020041cc08280200220145044041cc0841d40836020041d40821010b024041d0082802002202412046044041840210182201450d0120011027220141cc0828020036020041cc08200136020041d0084100360200410021020b41d008200241016a360200200120024102746a22014184016a4100360200200141046a20003602000b41c80841003602000bb20c01097f230041a0016b220124002001410036023820014200370330200141306a4114100a20012802301001200141186a200141306a100b2001200141306a100b200141c8006a4100360200200142003703400240034020024180086a2203410371044020024103460d02200241016a21020c010b0b200241fc076a21030340200341046a22032802002202417f73200241fffdfb776a7141808182847871450d000b0340200241ff0171450d01200341016a2d00002102200341016a21030c000b000b200141406b41800820034180086b100c4100210320014100360278200142003703704114100d20014114100e21054100210203402004411446044002402003044020012002410520036b74411f713a009001200141f0006a20014190016a100f0b410021032001410036028801200142003703800120014180016a200128024420012d0040220241017620024101711b410174410172100a200141406b410172210503402003200128024420012d00402202410176200241017122021b22044f0d0120012802800120036a2001280248200520021b20036a2d000022024105763a0000200128028001200128024420012d0040220441017620044101711b6a20036a41016a2002411f713a0000200341016a21030c000b000b05200420056a2d0000200241087441801e71722102200341086a21030340200341054e0440200120022003417b6a220376411f713a009001200141f0006a20014190016a100f0c010b0b200441016a21040c010b0b20012802800120046a41003a000020014190016a20014180016a2001280270200128027410102001280280012202044020012002360284010b20014190016a2001280294012001280290016b41066a100a20012802940120012802900122046b21024101210303402002044020042d000041002003411d764101716b41b3c5d1d0027141002003411c764101716b41dde788ea037141002003411b764101716b41fab384f5017141002003411a764101716b41ed9cc2b20271410020034119764101716b41b2afa9db0371200341057441e0ffffff037173737373737321032002417f6a2102200441016a21040c010b0b410021022001410036026820014200370360200141e0006a4106100a200341017321044119210303402003417b470440200128026020026a2004200376411f713a00002003417b6a2103200241016a21020c010b0b2001280290012202044020012002360294010b20014100360258200142003703500240200128027420012802706b2204450d0020012004100d2202360250200120023602542001200220046a3602582001280274200128027022036b22044101480d00200220032004100e1a2001200128025420046a3602540b20014190016a200141d0006a200128026020012802641010200128025022020440200120023602540b20004200370200200041086a4100360200200010062001280248200520012d0040220241017122041b210302402001280244200241017620041b220441016a410a4d0440200020044101743a0000200041016a21020c010b200441116a4170712205100d21022000200436020420002005410172360200200020023602080b2002200320041011200220046a41003a00002000413110120240200028020420002d00002206410176200641017122071b22022002200128029401220320012802900122046b6a2205200220054b1b220541106a417071417f6a410a2005410a4b1b220520002802002208417e71417f6a410a20071b2209460d00027f2005410a4604402008200620071b2106200041016a21074100210820002802080c010b4100200520094d200541016a100d22071b0d0120002d0000220641017104404101210820002802080c010b41012108200041016a0b2109200720092000280204200641fe017141017620064101711b41016a10112008044020002007360208200020023602042000200541016a4101723602000c010b200020024101743a00000b20042102034020032004470440200020022d00004184086a2c00001012200241016a21022003417f6a21030c010b0b2004044020012004360294010b200128026022000440200120003602640b200128027022000440200120003602740b200128023022000440200120003602340b200141a0016a24000bfa0101057f230041206b22022400024020002802042203200028020022046b22052001490440200028020820036b200120056b22044f04400340200341003a00002000200028020441016a22033602042004417f6a22040d000c030b000b2000200110132106200241186a200041086a3602002002410036021441002101200604402006100d21010b200220013602082002200120056a22033602102002200120066a3602142002200336020c0340200341003a00002002200228021041016a22033602102004417f6a22040d000b2000200241086a1014200241086a10150c010b200520014d0d002000200120046a3602040b200241206a24000b6201037f034020024114470440200020026a41003a0000200241016a21020c010b0b200128020021034100210203400240200241134d0440200220036a22042001280204470d010b0f0b200020026a20042d00003a0000200241016a21020c000b000b5a01027f02402002410a4d0440200020024101743a0000200041016a21030c010b200241106a4170712204100d21032000200236020420002004410172360200200020033602080b2003200120021011200220036a41003a00000b0b002000410120001b10180bf80801067f0340200020046a2105200120046a220341037145200220044672450440200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220845044003402006411049450440200020046a2202200120046a2203290200370200200241086a200341086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2202200120046a2201290200370200200141086a2103200241086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002008417f6a220841024b0d00024002400240024002400240200841016b0e020102000b2005200120046a220628020022033a0000200541016a200641016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2202200120046a220541046a2802002207410874200341187672360200200241046a200541086a2802002203410874200741187672360200200241086a2005410c6a28020022074108742003411876723602002002410c6a200541106a2802002203410874200741187672360200200441106a2104200641706a21060c000b000b2005200120046a220628020022033a0000200541016a200641016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2202200120046a220541046a2802002207411074200341107672360200200241046a200541086a2802002203411074200741107672360200200241086a2005410c6a28020022074110742003411076723602002002410c6a200541106a2802002203411074200741107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022033a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2202200120046a220541046a2802002207411874200341087672360200200241046a200541086a2802002203411874200741087672360200200241086a2005410c6a28020022074118742003410876723602002002410c6a200541106a2802002203411874200741087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000bb70101047f230041206b220224000240200028020422032000280208490440200320012d00003a00002000200028020441016a3602040c010b2000200320002802006b220441016a10132105200241186a200041086a3602004100210320024100360214200504402005100d21030b20022003360208200320046a220420012d00003a00002002200320056a3602142002200436020c2002200441016a3602102000200241086a1014200241086a10150b200241206a24000bc60301057f230041206b22042400200128020421050240200320026b22064101480d002006200128020820056b4c0440034020022003460d02200520022d00003a00002001200128020441016a2205360204200241016a21020c000b000b2001200520066a200128020022076b10132108200441186a200141086a3602004100210620044100360214200804402008100d21060b200420063602082004200520076b20066a22073602102004200620086a3602142004200736020c200441086a410472210603402002200346450440200720022d00003a00002004200428021041016a2207360210200241016a21020c010b0b200128020020052006101602402001280204220320056b220241004c0440200428021021020c010b2004200428021020052002100e20026a2202360210200128020421030b20012002360204200128020021022001200428020c3602002001280208210520012004280214360208200420033602102004200236020c2004200536021420042002360208200441086a1015200128020421050b20002005360204200141003602042000200128020036020020012802082102200141003602082000200236020820014100360200200441206a24000b100020020440200020012002100e1a0b0bf60101057f027f20002d00002202410171220345044020024101762104410a0c010b2000280204210420002802002202417e71417f6a0b210502400240024020042005460440027f2002410171044020002802080c010b200041016a0b2106416f2103200541e6ffffff074d0440410b20054101742202200541016a220320032002491b220241106a4170712002410b491b21030b2003100d220220062005101120002003410172360200200020023602080c010b2003450d01200028020821020b2000200441016a3602040c010b2000200441017441026a3a0000200041016a21020b200220046a220041003a0001200020013a00000b2e01017f2001200028020820002802006b2200410174220220022001491b41ffffffff07200041ffffffff03491b0b6701017f20002802002000280204200141046a1016200028020021022000200128020436020020012002360204200028020421022000200128020836020420012002360208200028020821022000200128020c3602082001200236020c200120012802043602000b2b01027f200028020821012000280204210203402001200247044020002001417f6a22013602080c010b0b0b270020022002280200200120006b22016b2202360200200141014e0440200220002001100e1a0b0b8e0b02077f017e230041e0006b220124001005100222001018220210030240200141086a20022000411c10192204280208450440200441146a2802002103200428021021020c010b200141386a2004101a2004200141c8006a2001280238200128023c41141019101b36020c200141c8006a2004101a2004027f410020012802482200450d001a4100200128024c2206200428020c2205490d001a200620052005417f461b210320000b2202360210200441146a2003360200200441003602080b200141c8006a20022003411410192200101c024002402000280204450d002000101c0240200028020022022c0000220341004e044020030d010c020b200341807f460d00200341ff0171220441b7014d0440200028020441014d04401000200028020021020b20022d00010d010c020b200441bf014b0d012000280204200341ff017141ca7e6a22034d04401000200028020021020b200220036a2d0000450d010b2000280204450d0020022d000041c001490d010b10000b2000101d2205200028020422024b04401000200028020421020b20002802002106024002400240200204404100210420062c00002200417f4a0d01027f200041ff0171220441bf014d04404100200041ff017141b801490d011a200441c97e6a0c010b4100200041ff017141f801490d001a200441897e6a0b41016a21040c010b4101210420060d00410021000c010b410021002002200549200420056a20024b720d004100210320022004490d01200420066a2103200220046b20052005417f461b22004109490d0110000c010b410021030b0340200004402000417f6a210020033100002007420886842107200341016a21030c010b0b02400240024002402007500d0041a508101e2007510d0341aa08101e2007520d00200141286a10092001410036025020014200370348200141c8006a4100101f200141dc006a410036020020014200370254410121030240200141386a200141286a1020220228020420012d00382200410176200041017122041b220041014d0440200041016b0d040c010b20004138490d02200041016a210303402000450d04200341016a2103200041087621000c000b000b2002280208200241016a20041b2c0000417f4c0d010c020b10000c020b200041016a21030b20012802502003490440200141c8006a2003101f0b41012100200141386a200141286a10202202280208200241016a20012d0038220341017122051b210402400240024002402002280204200341017620051b2202410146044020042c000022024100480d01200141c8006a200241ff017110210c040b200241374b0d01200221000b200141c8006a20004180017341ff017110210c010b20021022220041b7016a22034180024e044010000b200141c8006a200341ff01711021200141c8006a200128024c20006a1023200128024c20012802486a417f6a210320022100037f2000047f200320003a0000200041087621002003417f6a21030c010520020b0b21000b200141c8006a20001024200128024c220220012802486a20042000100e1a2001200020026a36024c0b034002402001280258220320012802544622040d00200341786a220028020022024504401000200028020021020b20002002417f6a220236020020020d0020012000360258200141c8006a4101200128024c22022003417c6a28020022036b22001022220441016a20004138491b220520026a102320052003200128024822056a22026a200220001025200041374d04402002200041406a3a00000c020b200441f7016a220641ff014d0440200220063a00002005200320046a6a210303402000450d03200320003a0000200041087621002003417f6a21030c000b000510000c020b000b0b200445044010000b2001280248200128024c100420012802542200450d00200120003602580b1026200141e0006a24000b970101047f230041106b220124002001200036020c2000047f41ec0a200041086a2202411076220041ec0a2802006a220336020041e80a200241e80a28020022026a41076a417871220436020002400240200341107420044d044041ec0a200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20022001410c6a4104100e41086a0541000b200141106a24000b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000101b20024f0d002003410471044010000c010b200042003702000b02402003411071450d002000101b20024d0d0020034104710440100020000f0b200042003702000b20000b7101047f2001101d220220012802044b044010000b2001102a21032000027f0240200128020022054504400c010b200220036a200128020422014b2001200349720d00410020012002490d011a200320056a2104200120036b20022002417f461b0c010b41000b360204200020043602000b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f2000102a2000101d6a0541010b0b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0bff0201037f200028020445044041000f0b2000101c41012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b2f01017f200028020820014904402001101820002802002000280204100e210220002001360208200020023602000b0b4d01017f20004200370200200041086a2202410036020020012d0000410171450440200020012902003702002002200141086a28020036020020000f0b200020012802082001280204100c20000b2500200041011024200028020020002802046a20013a00002000200028020441016a3602040b1e01017f03402000044020004108762100200141016a21010c010b0b20010b0f0020002001101f200020013602040b1b00200028020420016a220120002802084b044020002001101f0b0b8d0301037f024020002001460d00200120006b20026b410020024101746b4d0440200020012002100e1a0c010b20002001734103712103027f024020002001490440200020030d021a410021030340200120036a2104200020036a2205410371450440200220036b210241002103034020024104490d04200320056a200320046a280200360200200341046a21032002417c6a21020c000b000b20022003460d04200520042d00003a0000200341016a21030c000b000b024020030d002001417f6a21030340200020026a22044103714504402001417c6a21032000417c6a2104034020024104490d03200220046a200220036a2802003602002002417c6a21020c000b000b2002450d042004417f6a200220036a2d00003a00002002417f6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200320046a2101200320056a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b0b880101037f41c808410136020041cc082802002100034020000440034041d00841d0082802002201417f6a2202360200200141014845044041c8084100360200200020024102746a22004184016a280200200041046a28020011010041c808410136020041cc0828020021000c010b0b41d008412036020041cc08200028020022003602000c010b0b0bc90201037f200041003a000020004184026a2201417f6a41003a0000200041003a0002200041003a00012001417d6a41003a00002001417e6a41003a0000200041003a00032001417c6a41003a00002000410020006b41037122026a22014100360200200141840220026b417c7122036a2202417c6a4100360200024020034109490d002001410036020820014100360204200241786a4100360200200241746a410036020020034119490d002001410036021820014100360214200141003602102001410036020c200241706a41003602002002416c6a4100360200200241686a4100360200200241646a41003602002003200141047141187222036b2102200120036a2101034020024120490d0120014200370300200141186a4200370300200141106a4200370300200141086a4200370300200141206a2101200241606a21020c000b000b20000b3501017f230041106b220041f08a0436020c41e40a200028020c41076a417871220036020041e80a200036020041ec0a3f003602000b3801017f41d80a420037020041e00a410036020041742100034020000440200041e40a6a4100360200200041046a21000c010b0b410210080b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b0b4201004180080b3b6c61780071707a7279397838676632747664773073336a6e35346b686365366d7561376c00696e6974006765745f706c61746f6e5f63616c6c6572";

    public static String BINARY = BINARY_0;

    public static final String FUNC_GET_PLATON_CALLER = "get_platon_caller";

    protected CallerFunction(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    protected CallerFunction(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public RemoteCall<String> get_platon_caller() {
        final WasmFunction function = new WasmFunction(FUNC_GET_PLATON_CALLER, Arrays.asList(), String.class);
        return executeRemoteCall(function, String.class);
    }

    public static RemoteCall<CallerFunction> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(CallerFunction.class, web3j, credentials, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<CallerFunction> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(CallerFunction.class, web3j, transactionManager, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<CallerFunction> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(CallerFunction.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static RemoteCall<CallerFunction> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(CallerFunction.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static CallerFunction load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return new CallerFunction(contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    public static CallerFunction load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return new CallerFunction(contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }
}
