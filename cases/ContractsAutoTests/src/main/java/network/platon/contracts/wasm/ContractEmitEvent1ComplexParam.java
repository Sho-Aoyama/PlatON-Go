package network.platon.contracts.wasm;

import com.platon.rlp.datatypes.Uint32;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.web3j.abi.WasmEventEncoder;
import org.web3j.abi.WasmFunctionEncoder;
import org.web3j.abi.datatypes.WasmEvent;
import org.web3j.abi.datatypes.WasmEventParameter;
import org.web3j.abi.datatypes.WasmFunction;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.PlatonFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.WasmContract;
import org.web3j.tx.gas.GasProvider;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the org.web3j.codegen.WasmFunctionWrapperGenerator in the 
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with platon-web3j version 0.13.0.6.
 */
public class ContractEmitEvent1ComplexParam extends WasmContract {
    private static String BINARY_0 = "0x0061736d01000000014d0e60027f7f0060017f017f60017f0060037f7f7f017f60000060037f7f7f0060047f7f7f7f0060027f7f017f60047f7f7f7f017f60027f7e006000017f60027f7e017f60017e017f60017f017e02ba010803656e760c706c61746f6e5f70616e6963000403656e760b706c61746f6e5f73686133000603656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000a03656e7610706c61746f6e5f6765745f696e707574000203656e7617706c61746f6e5f6765745f73746174655f6c656e677468000703656e7610706c61746f6e5f6765745f7374617465000803656e7610706c61746f6e5f7365745f7374617465000603656e760c706c61746f6e5f6576656e74000603504f040102020205050207000300000107000900020b000206000701000100000103050100000308020300000501030403050201000d01020000040801090c0100030701040504010106000600000000000405017001030305030100020608017f0141e08a040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f727300080f5f5f66756e63735f6f6e5f65786974004006696e766f6b6500350908010041010b020a0a0ae46a4f100041a00810091a4101100b104a104c0b190020004200370200200041086a41003602002000100c20000b0300010b940101027f41ac08410136020041b008280200220145044041b00841b80836020041b80821010b024041b4082802002202412046044041840210332201450d0120011049220141b00828020036020041b008200136020041b4084100360200410021020b41b408200241016a360200200120024102746a22014184016a4100360200200141046a20003602000b41ac0841003602000b2201017f03402001410c470440200020016a4100360200200141046a21010c010b0b0bea0401077f230041b0016b22032400200341086a4100360200200342003703000240034020044180086a2205410371044020044108460d02200441016a21040c010b0b200441fc076a21050340200541046a22052802002204417f73200441fffdfb776a7141808182847871450d000b0340200441ff0171450d01200541016a2d00002104200541016a21050c000b000b200341800820054180086b100e200341e8006a100f200341fc006a410036020020034200370274200341e8006a410210102104200341d8006a20031011200341c8006a20001011200341406b4100360200200341386a4200370300200341306a420037030020034200370328200341286a20032802582205200328025c101220032802482206200328024c10122004200328022810132004200341d8006a10142004200341c8006a10142003280274200341f8006a28020047044010000b200428020421082004280200200341106a10152100200320013602800120034180016a4104722209200210162101200341a8016a4100360200200341a0016a420037030020034198016a4200370300200342003703900120034190016a4100101720034190016a200335028001101820034190016a2001101920034190016a41011017200328029001210220034190016a410472101a200020021013200041021010200335028001101b22002001101c2009101d200028020c200041106a28020047044010000b2008200028020020002802041007200028020c22010440200020013602100b41046a101a200604402003200636024c0b200504402003200536025c0b200328027422000440200320003602780b200341b0016a24000b5a01027f02402002410a4d0440200020024101743a0000200041016a21030c010b200241106a4170712204102121032000200236020420002004410172360200200020033602080b200320012002104b200220036a41003a00000b160020004100360208200042003702002000410010220b840201057f2001044020002802042104200041106a2802002202200041146a280200220349044020022001ad2004ad422086843702002000200028021041086a36021020000f0b027f41002002200028020c22026b410375220541016a2206200320026b2202410275220320032006491b41ffffffff01200241037541ffffffff00491b2203450d001a200341037410210b2102200220054103746a22052001ad2004ad4220868437020020052000280210200028020c22066b22016b2104200141014e044020042006200110341a0b2000200220034103746a3602142000200541086a3602102000200436020c20000f0b200041c00110552000410041004101105120000b870101037f230041306b22032400200341186a101522022001102310132002200341086a200110201024200228020c200241106a28020047044010000b2000410036020820004200370200200228020421012002280200200041201025200120002802002201200028020420016b1001200228020c22000440200220003602100b200341306a24000b8b0101017f024020012002460440410121030c010b4101210302400240200220016b2202410146044020012c0000417f4c0d010c030b200241374b0d010b200241016a21030c010b2002102620026a41016a21030b027f200041186a28020022010440200041086a280200200041146a280200200110270c010b20000b2201200128020020036a36020020000b1300200028020820014904402000200110220b0b1500200020012802002200200128020420006b10280b19002000100f200041146a41003602002000420037020c20000b840101037f200041003602082000200036020420002000360200200141046a2102037f20022802002203200146047f2000054114102122024100360200200241086a200341086a10201a20022000360204200028020021042000200236020020022004360200200420023602042000200028020841016a360208200341046a21020c010b0b0bbd0c02077f027e230041306b22052400200041046a2107024020014101460440200041086a280200200041146a280200200041186a220228020022041027280200210120022004417f6a360200200710294180104f044020072000410c6a280200417c6a102a0b200141384f047f2001102620016a0520010b41016a2101200041186a2802002202450d01200041086a280200200041146a2802002002102721000c010b0240200710290d00200041146a28020022014180084f0440200020014180786a360214200041086a2201280200220228020021042001200241046a360200200520043602182007200541186a102b0c010b2000410c6a2802002202200041086a2802006b4102752204200041106a2203280200220620002802046b220141027549044041802010212104200220064704400240200028020c220120002802102206470d0020002802082202200028020422034b04402000200220012002200220036b41027541016a417e6d41027422036a102c220136020c2000200028020820036a3602080c010b200541186a200620036b2201410175410120011b22012001410276200041106a102d2102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c200220093702082002102e200028020c21010b200120043602002000200028020c41046a36020c0c020b02402000280208220120002802042206470d00200028020c2202200028021022034904402000200120022002200320026b41027541016a41026d41027422036a102f22013602082000200028020c20036a36020c0c010b200541186a200320066b2201410175410120011b2201200141036a410276200041106a102d2102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c200220093702082002102e200028020821010b2001417c6a2004360200200020002802082201417c6a22023602082002280200210220002001360208200520023602182007200541186a102b0c010b20052001410175410120011b20042003102d210241802010212106024020022802082201200228020c2208470d0020022802042204200228020022034b04402002200420012004200420036b41027541016a417e6d41027422036a102c22013602082002200228020420036a3602040c010b200541186a200820036b2201410175410120011b22012001410276200241106a280200102d21042002280208210320022802042101034020012003470440200428020820012802003602002004200428020841046a360208200141046a21010c010b0b2002290200210920022004290200370200200420093702002002290208210920022004290208370208200420093702082004102e200228020821010b200120063602002002200228020841046a360208200028020c2104034020002802082004460440200028020421012000200228020036020420022001360200200228020421012002200436020420002001360208200029020c21092000200229020837020c200220093702082002102e052004417c6a210402402002280204220120022802002208470d0020022802082203200228020c22064904402002200120032003200620036b41027541016a41026d41027422066a102f22013602042002200228020820066a3602080c010b200541186a200620086b2201410175410120011b2201200141036a4102762002280210102d2002280208210620022802042101034020012006470440200528022020012802003602002005200528022041046a360220200141046a21010c010b0b20022902002109200220052903183702002002290208210a20022005290320370208200520093703182005200a370320102e200228020421010b2001417c6a200428020036020020022002280204417c6a3602040c010b0b0b200541186a20071030200528021c4100360200200041186a2100410121010b2000200028020020016a360200200541306a24000b840102027f017e4101210320014280015a0440034020012004845045044020044238862001420888842101200241016a2102200442088821040c010b0b200241384f047f2002102620026a0520020b41016a21030b200041186a28020022020440200041086a280200200041146a2802002002102721000b2000200028020020036a3602000b8c0101027f230041106b2203240002402001280208450440200041186a28020022010440200041086a280200200041146a2802002001102721000b2000200028020041016a3602000c010b200041001017200141046a210203402002280200220220014604402000410110170520002003200241086a10201031200241046a21020c010b0b0b200341106a24000bea0101047f230041106b22042400200028020422012000280210220341087641fcffff07716a2102027f410020012000280208460d001a2002280200200341ff07714102746a0b2101200441086a20001030200428020c210303400240200120034604402000410036021420002802082102200028020421010340200220016b41027522034103490d022000200141046a22013602040c000b000b200141046a220120022802006b418020470d0120022802042101200241046a21020c010b0b2003417f6a220241014d04402000418004418008200241016b1b3602100b20002001102a200441106a24000bbc0202037f037e02402001500440200041800110550c010b20014280015a044020012107034020062007845045044020064238862007420888842107200241016a2102200642088821060c010b0b0240200241384f04402002210303402003044020034108762103200441016a21040c010b0b200441c9004f044010000b2000200441b77f6a41ff017110552000200028020420046a1054200028020420002802006a417f6a21042002210303402003450d02200420033a0000200341087621032004417f6a21040c000b000b200020024180017341ff017110550b2000200028020420026a1054200028020420002802006a417f6a210203402001200584500d02200220013c0000200542388620014208888421012002417f6a2102200542088821050c000b000b20002001a741ff017110550b20004101105320000b4d01027f230041106b22032400200141046a210220002001280208101021000340200228020022022001460440200341106a24000520002003200241086a10201024200241046a21020c010b0b0b4d01037f02402000280208450d00200028020422012802002202200028020022032802043602042000410036020820032802042002360200034020002001460d01200128020421010c000b000b0b2f01017f230041106b22042400200041186a2001101f200120022004200310162200100d2000101d200441106a24000b880201047f20002001470440200128020420012d00002202410176200241017122031b2102200141016a21042001280208410a2101200420031b210420002d0000410171220304402000280200417e71417f6a21010b200220014d0440027f2003044020002802080c010b200041016a0b21012002044020012004200210320b200120026a41003a000020002d00004101710440200020023602040f0b200020024101743a00000f0b416f2103200141e6ffffff074d0440410b20014101742201200220022001491b220141106a4170712001410b491b21030b20031021220120042002104b200020023602042000200341017236020020002001360208200120026a41003a00000b0b4d01017f20004200370200200041086a2202410036020020012d0000410171450440200020012902003702002002200141086a28020036020020000f0b200020012802082001280204100e20000b0b002000410120001b10330b2f01017f2000280208200149044020011033200028020020002802041034210220002001360208200020023602000b0b5501017f230041306b22012400200141286a4100360200200141206a4200370300200141186a420037030020014200370310200141106a20012000102010312001280210200141106a410472101a200141306a24000b2c01017f20002001280208200141016a20012d0000220041017122021b2001280204200041017620021b10280bf90101067f024020002802042202200028020022056b220320014904402000280208220720026b200120036b22044f04400340200241003a00002000200028020441016a22023602042004417f6a22040d000c030b000b2001200720056b2202410174220520052001491b41ffffffff07200241ffffffff03491b220104402001102121060b200320066a220321020340200241003a0000200241016a21022004417f6a22040d000b20032000280204200028020022056b22046b2103200441014e044020032005200410341a0b2000200120066a36020820002002360204200020033602000f0b200320014d0d002000200120056a3602040b0b1e01017f03402000044020004108762100200141016a21010c010b0b20010b25002000200120026a417f6a220141087641fcffff07716a280200200141ff07714102746a0b6901017f4101210302400240024002402002410146044020012c000022024100480d012000200241ff017110550c040b200241374b0d01200221030b200020034180017341ff017110550c010b200020021056200221030b200020012003410010510b2000410110530b2801017f200028020820002802046b2201410874417f6a410020011b200028021420002802106a6b0b2501017f200028020821020340200120024645044020002002417c6a22023602080c010b0b0ba10202057f017e230041206b22052400024020002802082202200028020c2206470d0020002802042203200028020022044b04402000200320022003200320046b41027541016a417e6d41027422046a102c22023602082000200028020420046a3602040c010b200541086a200620046b2202410175410120021b220220024102762000410c6a102d2103200028020821042000280204210203402002200446450440200328020820022802003602002003200328020841046a360208200241046a21020c010b0b2000290200210720002003290200370200200320073702002000290208210720002003290208370208200320073702082003102e200028020821020b200220012802003602002000200028020841046a360208200541206a24000b2501017f200120006b220141027521032001044020022000200110320b200220034102746a0b4f01017f2000410036020c200041106a2003360200200104402001410274102121040b200020043602002000200420024102746a22023602082000200420014102746a36020c2000200236020420000b2b01027f200028020821012000280204210203402001200247044020002001417c6a22013602080c010b0b0b1b00200120006b22010440200220016b22022000200110320b20020b4f01037f20012802042203200128021020012802146a220441087641fcffff07716a21022000027f410020032001280208460d001a2002280200200441ff07714102746a0b360204200020023602000b9a0101037f41012103024002400240200128020420012d00002202410176200241017122041b220241014d0440200241016b0d032001280208200141016a20041b2c0000417f4c0d010c030b200241374b0d010b200241016a21030c010b2002102620026a41016a21030b200041186a28020022010440200041086a280200200041146a2802002001102721000b2000200028020020036a3602000b8d0301037f024020002001460d00200120006b20026b410020024101746b4d044020002001200210341a0c010b20002001734103712103027f024020002001490440200020030d021a410021030340200120036a2104200020036a2205410371450440200220036b210241002103034020024104490d04200320056a200320046a280200360200200341046a21032002417c6a21020c000b000b20022003460d04200520042d00003a0000200341016a21030c000b000b024020030d002001417f6a21030340200020026a22044103714504402001417c6a21032000417c6a2104034020024104490d03200220046a200220036a2802003602002002417c6a21020c000b000b2002450d042004417f6a200220036a2d00003a00002002417f6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200320046a2101200320056a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b0b970101047f230041106b220124002001200036020c2000047f41d00a200041086a2202411076220041d00a2802006a220336020041cc0a200241cc0a28020022026a41076a417871220436020002400240200341107420044d044041d00a200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20022001410c6a4104103441086a0541000b200141106a24000bf80801067f0340200020046a2105200120046a220341037145200220044672450440200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220845044003402006411049450440200020046a2202200120046a2203290200370200200241086a200341086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2202200120046a2201290200370200200141086a2103200241086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002008417f6a220841024b0d00024002400240024002400240200841016b0e020102000b2005200120046a220628020022033a0000200541016a200641016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2202200120046a220541046a2802002207410874200341187672360200200241046a200541086a2802002203410874200741187672360200200241086a2005410c6a28020022074108742003411876723602002002410c6a200541106a2802002203410874200741187672360200200441106a2104200641706a21060c000b000b2005200120046a220628020022033a0000200541016a200641016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2202200120046a220541046a2802002207411074200341107672360200200241046a200541086a2802002203411074200741107672360200200241086a2005410c6a28020022074110742003411076723602002002410c6a200541106a2802002203411074200741107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022033a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2202200120046a220541046a2802002207411874200341087672360200200241046a200541086a2802002203411874200741087672360200200241086a2005410c6a28020022074118742003410876723602002002410c6a200541106a2802002203411874200741087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000b960402067f017e230041c0016b22002400100810022201103322021003200041206a200041086a200220011036220341001037200041206a103802400240200041206a1039450d002000280224450d0020002802202d000041c001490d010b10000b200041f0006a200041206a103a2000280274220141094f044010000b200028027021020340200104402001417f6a210120023100002006420886842106200241016a21020c010b0b024002402006500d00418908103b2006510440200041206a103c103d0c020b418e08103b2006520d00200041f0006a1009210520004188016a410036020020004184016a20004180016a220136020020002001360280012000410036027c200041206a200341011037200041206a2005103e200041206a200341021037200041206a103802400240200041206a1039450d002000280224450d0020002802202d000041c001490d010b10000b200041b0016a200041206a103a20002802b401220141054f044010000b20002802b00121020340200104402001417f6a210120022d00002004410874722104200241016a21020c010b0b2000200436027c200041206a200341031037200041206a20004180016a2201103f200041206a103c2102200041a0016a200510202104200028027c210520004190016a2001101621032002200041b0016a2004102020052003101e2003101d2002103d2001101d0c010b10000b1040200041c0016a24000b0c00200020012002411c10410bc90202077f017e230041106b220324002001280208220520024b0440200341086a2001105020012003280208200328020c104836020c200320011050410021052001027f410020032802002206450d001a410020032802042208200128020c2207490d001a200820072007417f461b210420060b360210200141146a2004360200200141003602080b200141106a210903402001280214210402402005200249044020040d01410021040b200020092802002004411410411a200341106a24000f0b20032001105041002104027f410020032802002207450d001a410020032802042208200128020c2206490d001a200820066b2104200620076a0b21052001200436021420012005360210200320094100200520041048104f20012003290300220a3702102001200128020c200a422088a76a36020c2001200128020841016a22053602080c000b000b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0b980101037f200028020445044041000f0b20001038200028020022022c0000220141004e044020014100470f0b027f4101200141807f460d001a200141ff0171220341b7014d0440200028020441014d047f100020002802000520020b2d00014100470f0b4100200341bf014b0d001a2000280204200141ff017141ca7e6a22014d047f100020002802000520020b20016a2d00004100470b0bd40101047f200110422204200128020422024b04401000200128020421020b200128020021052000027f02400240200204404100210120052c00002203417f4a0d01027f200341ff0171220141bf014d04404100200341ff017141b801490d011a200141c97e6a0c010b4100200341ff017141f801490d001a200141897e6a0b41016a21010c010b4101210120050d000c010b410021032002200149200120046a20024b720d00410020022004490d011a200120056a2103200220016b20042004417f461b0c010b41000b360204200020033602000b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b9206010a7f230041406a22032400200010092106200042afb59bdd9e8485b9f800370310200041186a10092107200341286a1015220120002903101043200128020c200141106a28020047044010000b0240200128020022042001280204220810042202450d002003410036022020034200370318200341186a200210252004200820032802182204200328021c220820046b1005417f4704402003200441016a20082004417f736a10362007103e200221050b2004450d002003200436021c0b200128020c22020440200120023602100b200545044020072006101f0b41002105200041c8006a4100360200200041c4006a2201200041406b2207360200200041386a220242f4ffce959b97c9c1d500370300200041306a41003602002000412c6a2204200041286a22093602002000200936022820072007360200200341286a1015220620022903001043200628020c200641106a28020047044010000b0240200628020022082006280204220a10042202450d002003410036022020034200370318200341186a200210252008200a20032802182208200328021c220a20086b1005417f4704402003200841016a200a2008417f736a10362007103f200221050b2008450d002003200836021c0b200628020c22020440200620023602100b024020050d000340200128020021010240027f4101200428020022042009460d001a20012007470d0141000b210502402001200746044020050d044114102122014100360200200141086a200441086a10201a20012105410121060340200920042802042204460d0241141021220241086a200441086a10201a2002200536020020052002360204200641016a2106200221050c000b000b200128020022052007280200220228020436020420022802042005360200034020012007460d0420002000280248417f6a360248200128020421010c000b000b2000280240220220013602042001200236020020002005360240200520073602042000200028024820066a3602480c020b200141086a200441086a101f200141046a2101200441046a21040c000b000b200341406b240020000bcd0401087f230041e0006b22022400200241c8006a10152203200041386a220129030010441013200320012903001043200328020c200341106a28020047044010000b200328020421072003280200200210152101200241306a4100360200200241286a4200370300200241206a420037030020024200370318200241186a200041406b2204101920022802182105200241186a410472101a2001200241186a1045220610462001200520062802046a20062802006b101320012004101c0240200128020c200141106a280200460440200141046a2104200128020021050c010b200141046a2104100020012802002105200128020c2001280210460d0010000b2007200520042802001006200628020022040440200620043602040b200128020c22040440200120043602100b200328020c22010440200320013602100b200041406b101d200041286a101d200241186a10152203200029031010441013200320002903101043200328020c200341106a28020047044010000b200328020421062003280200200241c8006a10152101200041186a220410232105200120021045220010462001200520002802046a20002802006b10132001200241386a2004102010240240200128020c200141106a280200460440200141046a2104200128020021050c010b200141046a2104100020012802002105200128020c2001280210460d0010000b2006200520042802001006200028020022040440200020043602040b200128020c22000440200120003602100b200328020c22000440200320003602100b200241e0006a24000bf40201057f230041206b22022400024002402000280204044020002802002d000041c001490d010b200241086a10091a0c010b200241186a2000103a2000104221030240024002400240200228021822000440200228021c220420034f0d010b41002100200241106a410036020020024200370308410021040c010b200241106a4100360200200242003703082000200420032003417f461b22046a21052004410a4b0d010b200220044101743a0008200241086a41017221030c010b200441106a4170712206102121032002200436020c20022006410172360208200220033602100b03402000200546450440200320002d00003a0000200341016a2103200041016a21000c010b0b200341003a00000b024020012d0000410171450440200141003b01000c010b200128020841003a00002001410036020420012d0000410171450d00200141003602000b20012002290308370200200141086a200241106a280200360200200241086a100c200241206a24000b830301077f230041d0006b22042400024002402000280204450d0020002802002d000041c001490d00200441406b2000410110472103200441306a200041001047210620032802042100200441106a2107034020062802042000464100200328020822022006280208461b0d02200441186a20002002411c1041200441086a10092202103e411410212200410036020020002004290308370208200041106a20072802003602002002100c20002001360204200128020021022001200036020020002002360200200220003602042001200128020841016a36020820032003280204220020032802086a410020001b22003602042003280200220204402003200236020820002002104821002003027f200328020422054504404100210241000c010b410021024100200328020822082000490d001a200820002000417f461b210220050b2200ad2002ad42208684370204200341002003280200220520026b2202200220054b1b36020005200341003602080b0c000b000b10000b200441d0006a24000b880101037f41ac08410136020041b0082802002100034020000440034041b40841b4082802002201417f6a2202360200200141014845044041ac084100360200200020024102746a22004184016a280200200041046a28020011020041ac08410136020041b00828020021000c010b0b41b408412036020041b008200028020022003602000c010b0b0b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000104d20024f0d002003410471044010000c010b200042003702000b02402003411071450d002000104d20024d0d0020034104710440100020000f0b200042003702000b20000bff0201037f200028020445044041000f0b2000103841012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b090020002001101b1a0b4b01027f230041206b22012400200141186a4100360200200141106a4200370300200141086a42003703002001420037030020012000101820012802002001410472101a200141206a24000b3a01017f20004100360208200042003702002000410110212201360200200141fe013a00002000200141016a22013602082000200136020420000b6101037f200028020c200041106a28020047044010000b200028020422022001280204200128020022036b22016a220420002802084b047f20002004102220002802040520020b20002802006a2003200110341a2000200028020420016a3602040be70101037f230041106b2204240020004200370200200041086a410036020020012802042103024002402002450440200321020c010b410021022003450d002003210220012802002d000041c001490d00200441086a2001105020004100200428020c2201200428020822022001104822032003417f461b20024520012003497222031b220536020820004100200220031b3602042000200120056b3602000c010b20012802002103200128020421012000410036020020004100200220016b20034520022001497222021b36020820004100200120036a20021b3602040b200441106a240020000b2301017f230041206b22022400200241086a2000200141141041104d200241206a24000bc90201037f200041003a000020004184026a2201417f6a41003a0000200041003a0002200041003a00012001417d6a41003a00002001417e6a41003a0000200041003a00032001417c6a41003a00002000410020006b41037122026a22014100360200200141840220026b417c7122036a2202417c6a4100360200024020034109490d002001410036020820014100360204200241786a4100360200200241746a410036020020034119490d002001410036021820014100360214200141003602102001410036020c200241706a41003602002002416c6a4100360200200241686a4100360200200241646a41003602002003200141047141187222036b2102200120036a2101034020024120490d0120014200370300200141186a4200370300200141106a4200370300200141086a4200370300200141206a2101200241606a21020c000b000b20000b3501017f230041106b220041e08a0436020c41c80a200028020c41076a417871220036020041cc0a200036020041d00a3f003602000b10002002044020002001200210341a0b0b3801017f41bc0a420037020041c40a410036020041742100034020000440200041c80a6a4100360200200041046a21000c010b0b4102100b0b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f2000104e200010426a0541010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b5a01027f2000027f0240200128020022054504400c010b200220036a200128020422014b2001200249720d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000b2101017f20011042220220012802044b044010000b200020012001104e2002104f0b2d00200020021052200028020020002802046a2001200210341a2000200028020420026a3602042000200310530b1b00200028020420016a220120002802084b04402000200110220b0b820201047f02402001450d00034020002802102202200028020c460d01200241786a28020020014904401000200028021021020b200241786a2203200328020020016b220136020020010d012000200336021020004101200028020422042002417c6a28020022016b22021026220341016a20024138491b220520046a1054200120002802006a220420056a2004200210320240200241374d0440200028020020016a200241406a3a00000c010b200341f7016a220441ff014d0440200028020020016a20043a00002000280200200120036a6a210103402002450d02200120023a0000200241087621022001417f6a21010c000b000b10000b410121010c000b000b0b0f00200020011022200020013602040b2500200041011052200028020020002802046a20013a00002000200028020441016a3602040b5e01027f20011026220241b7016a22034180024e044010000b2000200341ff017110552000200028020420026a1054200028020420002802006a417f6a2100034020010440200020013a0000200141087621012000417f6a21000c010b0b0b0b2401004180080b1d7472616e7366657200696e6974006f6e655f656d69745f6576656e7431";

    public static String BINARY = BINARY_0;

    public static final String FUNC_ONE_EMIT_EVENT1 = "one_emit_event1";

    public static final String FUNC_GET_STRING = "get_string";

    public static final WasmEvent TRANSFER_EVENT = new WasmEvent("transfer", Arrays.asList(new WasmEventParameter(String.class, true)), Arrays.asList(new WasmEventParameter(Uint32.class) , new WasmEventParameter(List.class, 
            new com.platon.rlp.ParameterizedTypeImpl(
            new java.lang.reflect.Type[] {java.lang.String.class}, 
            java.util.List.class, 
            java.util.List.class))));
    ;

    protected ContractEmitEvent1ComplexParam(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    protected ContractEmitEvent1ComplexParam(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<WasmContract.WasmEventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (WasmContract.WasmEventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.topic = (String) eventValues.getIndexedValues().get(0);
            typedResponse.arg1 = (Uint32) eventValues.getNonIndexedValues().get(0);
            typedResponse.arg2 = (List<String>) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(PlatonFilter filter) {
        return web3j.platonLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                WasmContract.WasmEventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.topic = (String) eventValues.getIndexedValues().get(0);
                typedResponse.arg1 = (Uint32) eventValues.getNonIndexedValues().get(0);
                typedResponse.arg2 = (List<String>) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        PlatonFilter filter = new PlatonFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(WasmEventEncoder.encode(TRANSFER_EVENT));
        return transferEventObservable(filter);
    }

    public static RemoteCall<ContractEmitEvent1ComplexParam> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ContractEmitEvent1ComplexParam.class, web3j, credentials, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<ContractEmitEvent1ComplexParam> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ContractEmitEvent1ComplexParam.class, web3j, transactionManager, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<ContractEmitEvent1ComplexParam> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ContractEmitEvent1ComplexParam.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static RemoteCall<ContractEmitEvent1ComplexParam> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ContractEmitEvent1ComplexParam.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public RemoteCall<TransactionReceipt> one_emit_event1(String name, Uint32 value, List<String> inList) {
        final WasmFunction function = new WasmFunction(FUNC_ONE_EMIT_EVENT1, Arrays.asList(name,value,inList), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> one_emit_event1(String name, Uint32 value, List<String> inList, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_ONE_EMIT_EVENT1, Arrays.asList(name,value,inList), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<String> get_string() {
        final WasmFunction function = new WasmFunction(FUNC_GET_STRING, Arrays.asList(), String.class);
        return executeRemoteCall(function, String.class);
    }

    public static ContractEmitEvent1ComplexParam load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return new ContractEmitEvent1ComplexParam(contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    public static ContractEmitEvent1ComplexParam load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return new ContractEmitEvent1ComplexParam(contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public static class TransferEventResponse {
        public Log log;

        public String topic;

        public Uint32 arg1;

        public List<String> arg2;
    }
}
