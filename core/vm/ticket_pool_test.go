package vm_test

import (
	"bytes"
	"encoding/hex"
	"encoding/json"
	"fmt"
	"github.com/PlatONnetwork/PlatON-Go/common"
	"github.com/PlatONnetwork/PlatON-Go/common/byteutil"
	"github.com/PlatONnetwork/PlatON-Go/common/hexutil"
	"github.com/PlatONnetwork/PlatON-Go/core/vm"
	"github.com/PlatONnetwork/PlatON-Go/p2p/discover"
	"github.com/PlatONnetwork/PlatON-Go/rlp"
	"math/big"
	"testing"
)

func TestTicketPoolOverAll(t *testing.T) {

	ticketContract := vm.TicketContract{
		newContract(),
		newEvm(),
	}
	candidateContract := vm.CandidateContract{
		newContract(),
		newEvm(),
	}

	// CandidateDeposit(nodeId discover.NodeID, owner common.Address, fee uint64, host, port, extra string) ([]byte, error)
	nodeId := discover.MustHexID("0x01234567890121345678901123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345")
	owner := common.HexToAddress("0x12")
	fee := uint64(1)
	host := "10.0.0.1"
	port := "8548"
	extra := "extra data"
	fmt.Println("CandidateDeposit input==>", "nodeId: ", nodeId.String(), "owner: ", owner.Hex(), "fee: ", fee, "host: ", host, "port: ", port, "extra: ", extra)
	_, err := candidateContract.CandidateDeposit(nodeId, owner, fee, host, port, extra)
	if nil != err {
		fmt.Println("CandidateDeposit fail", "err", err)
	}
	fmt.Println("质押成功...")

	// VoteTicket(count uint64, price *big.Int, nodeId discover.NodeID) ([]byte, error)
	count := uint64(1000)
	price := big.NewInt(1)
	fmt.Println("VoteTicket input==>", "count: ", count, "price: ", price, "nodeId: ", nodeId.String())
	resByte, err := ticketContract.VoteTicket(count, price, nodeId)
	if nil != err {
		fmt.Println("VoteTicket fail", "err", err)
	}
	fmt.Println("The list of generated ticketId is: ", vm.ResultByte2Json(resByte))

	/*// GetCandidateTicketIds(nodeId discover.NodeID) ([]byte, error)
	fmt.Println("GetCandidateTicketIds input==>", "nodeId: ", nodeId.String())
	// TODO 查询候选人的选票列表
	resByte, err = ticketContract.GetCandidateTicketIds(nodeId)
	if nil != err {
		fmt.Println("GetCandidateTicketIds fail", "err", err)
	}
	fmt.Println("The candidate's ticketId are: ", vm.ResultByte2Json(resByte))*/

	// GetTicketDetail(ticketId common.Hash) ([]byte, error)
	ticketId := common.HexToHash("e69d8e6dbc1ee87d7fb20600f3fc6744f28b637d43b5a130b2904c30d12e9b30")
	fmt.Println("GetTicketDetail input==>", "ticketId: ", ticketId.String())
	resByte, err = ticketContract.GetTicketDetail(ticketId)
	if nil != err {
		fmt.Println("GetTicketDetail fail", "err", err)
	}
	fmt.Println("ticketInfo is: ", vm.ResultByte2Json(resByte))

	// GetBatchTicketDetail(ticketIds []common.Hash) ([]byte, error)
	ticketIds := []common.Hash{common.HexToHash("e69d8e6dbc1ee87d7fb20600f3fc6744f28b637d43b5a130b2904c30d12e9b30"), common.HexToHash("008674dae3f0c660158fe602589c5505b20e24be4caa8f65c0f92ff372149ccc")}
	input, _ := json.Marshal(ticketIds)
	fmt.Println("GetBatchTicketDetail input==>", "ticketIds: ", string(input))
	resByte, err = ticketContract.GetBatchTicketDetail(ticketIds)
	if nil != err {
		fmt.Println("GetBatchTicketDetail fail", "err", err)
	}
	fmt.Println("ticketInfo is: ", vm.ResultByte2Json(resByte))
}

func TestVoteTicket(t *testing.T) {
	ticketContract := vm.TicketContract{
		newContract(),
		newEvm(),
	}
	candidateContract := vm.CandidateContract{
		newContract(),
		newEvm(),
	}
	nodeId := discover.MustHexID("0x01234567890121345678901123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345")
	owner := common.HexToAddress("0x12")
	fee := uint64(1)
	host := "10.0.0.1"
	port := "8548"
	extra := "extra data"
	fmt.Println("CandidateDeposit input==>", "nodeId: ", nodeId.String(), "owner: ", owner.Hex(), "fee: ", fee, "host: ", host, "port: ", port, "extra: ", extra)
	_, err := candidateContract.CandidateDeposit(nodeId, owner, fee, host, port, extra)
	if nil != err {
		fmt.Println("CandidateDeposit fail", "err", err)
	}

	// VoteTicket(count uint64, price *big.Int, nodeId discover.NodeID) ([]byte, error)
	count := uint64(1000)
	price := big.NewInt(1)
	fmt.Println("VoteTicket input==>", "count: ", count, "price: ", price, "nodeId: ", nodeId.String())
	resByte, err := ticketContract.VoteTicket(count, price, nodeId)
	if nil != err {
		fmt.Println("VoteTicket fail", "err", err)
	}
	fmt.Println("The list of generated ticketId is: ", vm.ResultByte2Json(resByte))
}

func TestGetTicketDetail(t *testing.T) {
	ticketContract := vm.TicketContract{
		newContract(),
		newEvm(),
	}
	candidateContract := vm.CandidateContract{
		newContract(),
		newEvm(),
	}
	nodeId := discover.MustHexID("0x01234567890121345678901123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345")
	owner := common.HexToAddress("0x12")
	fee := uint64(1)
	host := "10.0.0.1"
	port := "8548"
	extra := "extra data"
	fmt.Println("CandidateDeposit input==>", "nodeId: ", nodeId.String(), "owner: ", owner.Hex(), "fee: ", fee, "host: ", host, "port: ", port, "extra: ", extra)
	_, err := candidateContract.CandidateDeposit(nodeId, owner, fee, host, port, extra)
	if nil != err {
		fmt.Println("CandidateDeposit fail", "err", err)
	}
	count := uint64(1000)
	price := big.NewInt(1)
	fmt.Println("VoteTicket input==>", "count: ", count, "price: ", price, "nodeId: ", nodeId.String())
	resByte, err := ticketContract.VoteTicket(count, price, nodeId)
	if nil != err {
		fmt.Println("VoteTicket fail", "err", err)
	}
	fmt.Println("The list of generated ticketId is: ", vm.ResultByte2Json(resByte))

	// GetTicketDetail(ticketId common.Hash) ([]byte, error)
	ticketId := common.HexToHash("e69d8e6dbc1ee87d7fb20600f3fc6744f28b637d43b5a130b2904c30d12e9b30")
	fmt.Println("GetTicketDetail input==>", "ticketId: ", ticketId.String())
	resByte, err = ticketContract.GetTicketDetail(ticketId)
	if nil != err {
		fmt.Println("GetTicketDetail fail", "err", err)
	}
	if nil == resByte {
		fmt.Println("The ticket info is null")
		return
	}
	fmt.Println("ticketInfo is: ", vm.ResultByte2Json(resByte))
}

func TestGetBatchTicketDetail(t *testing.T) {
	ticketContract := vm.TicketContract{
		newContract(),
		newEvm(),
	}
	candidateContract := vm.CandidateContract{
		newContract(),
		newEvm(),
	}
	nodeId := discover.MustHexID("0x01234567890121345678901123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345")
	owner := common.HexToAddress("0x12")
	fee := uint64(1)
	host := "10.0.0.1"
	port := "8548"
	extra := "extra data"
	fmt.Println("CandidateDeposit input==>", "nodeId: ", nodeId.String(), "owner: ", owner.Hex(), "fee: ", fee, "host: ", host, "port: ", port, "extra: ", extra)
	_, err := candidateContract.CandidateDeposit(nodeId, owner, fee, host, port, extra)
	if nil != err {
		fmt.Println("CandidateDeposit fail", "err", err)
	}
	count := uint64(1000)
	price := big.NewInt(1)
	fmt.Println("VoteTicket input==>", "count: ", count, "price: ", price, "nodeId: ", nodeId.String())
	resByte, err := ticketContract.VoteTicket(count, price, nodeId)
	if nil != err {
		fmt.Println("VoteTicket fail", "err", err)
	}
	fmt.Println("The list of generated ticketId is: ", vm.ResultByte2Json(resByte))

	// GetBatchTicketDetail(ticketIds []common.Hash) ([]byte, error)
	ticketIds := []common.Hash{common.HexToHash("e69d8e6dbc1ee87d7fb20600f3fc6744f28b637d43b5a130b2904c30d12e9b30"), common.HexToHash("008674dae3f0c660158fe602589c5505b20e24be4caa8f65c0f92ff372149ccc")}
	input, _ := json.Marshal(ticketIds)
	fmt.Println("GetBatchTicketDetail input==>", "ticketIds: ", string(input))
	resByte, err = ticketContract.GetBatchTicketDetail(ticketIds)
	if nil != err {
		fmt.Println("GetBatchTicketDetail fail", "err", err)
	}
	if nil == resByte {
		fmt.Println("The batch ticket info is null")
		return
	}
	fmt.Println("ticketInfo is: ", vm.ResultByte2Json(resByte))
}

func TestGetCandidateTicketIds(t *testing.T) {
	ticketContract := vm.TicketContract{
		newContract(),
		newEvm(),
	}
	candidateContract := vm.CandidateContract{
		newContract(),
		newEvm(),
	}
	nodeId := discover.MustHexID("0x01234567890121345678901123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345")
	owner := common.HexToAddress("0x12")
	fee := uint64(1)
	host := "10.0.0.1"
	port := "8548"
	extra := "extra data"
	fmt.Println("CandidateDeposit input==>", "nodeId: ", nodeId.String(), "owner: ", owner.Hex(), "fee: ", fee, "host: ", host, "port: ", port, "extra: ", extra)
	_, err := candidateContract.CandidateDeposit(nodeId, owner, fee, host, port, extra)
	if nil != err {
		fmt.Println("CandidateDeposit fail", "err", err)
	}
	count := uint64(1000)
	price := big.NewInt(1)
	fmt.Println("VoteTicket input==>", "count: ", count, "price: ", price, "nodeId: ", nodeId.String())
	resByte, err := ticketContract.VoteTicket(count, price, nodeId)
	if nil != err {
		fmt.Println("VoteTicket fail", "err", err)
	}
	fmt.Println("The list of generated ticketId is: ", vm.ResultByte2Json(resByte))

	// GetCandidateTicketIds(nodeId discover.NodeID) ([]byte, error)
	fmt.Println("GetCandidateTicketIds input==>", "nodeId: ", nodeId.String())
	// TODO 查询候选人的选票列表
	resByte, err = ticketContract.GetCandidateTicketIds(nodeId)
	if nil != err {
		fmt.Println("GetCandidateTicketIds fail", "err", err)
	}
	if nil == resByte {
		fmt.Println("The candidate's ticket list is null")
		return
	}
	fmt.Println("The candidate's ticketId are: ", vm.ResultByte2Json(resByte))
}

func TestGetCandidateEpoch(t *testing.T) {
	ticketContract := vm.TicketContract{
		newContract(),
		newEvm(),
	}
	candidateContract := vm.CandidateContract{
		newContract(),
		newEvm(),
	}
	nodeId := discover.MustHexID("0x01234567890121345678901123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345")
	owner := common.HexToAddress("0x12")
	fee := uint64(1)
	host := "10.0.0.1"
	port := "8548"
	extra := "extra data"
	fmt.Println("CandidateDeposit input==>", "nodeId: ", nodeId.String(), "owner: ", owner.Hex(), "fee: ", fee, "host: ", host, "port: ", port, "extra: ", extra)
	_, err := candidateContract.CandidateDeposit(nodeId, owner, fee, host, port, extra)
	if nil != err {
		fmt.Println("CandidateDeposit fail", "err", err)
	}
	count := uint64(1000)
	price := big.NewInt(1)
	fmt.Println("VoteTicket input==>", "count: ", count, "price: ", price, "nodeId: ", nodeId.String())
	resByte, err := ticketContract.VoteTicket(count, price, nodeId)
	if nil != err {
		fmt.Println("VoteTicket fail", "err", err)
	}

	// GetCandidateEpoch(nodeId discover.NodeID) ([]byte, error)
	// TODO
	fmt.Println("GetCandidateEpoch input==>", "nodeId: ", nodeId.String())
	resByte, err = ticketContract.GetCandidateEpoch(nodeId)
	if nil != err {
		fmt.Println("GetCandidateEpoch fail", "err", err)
	}
	fmt.Println("The candidate's epoch is: ", vm.ResultByte2Json(resByte))

}

func TestGetTicketPrice(t *testing.T) {
	ticketContract := vm.TicketContract{
		newContract(),
		newEvm(),
	}

	// GetTicketPrice() ([]byte, error)
	resByte, err := ticketContract.GetTicketPrice()
	if nil != err {
		fmt.Println("GetTicketPrice fail", "err", err)
	}
	fmt.Println("The ticket price is: ", vm.ResultByte2Json(resByte))
}

func TestTicketPoolEncode(t *testing.T) {
	nodeId := []byte("0x1f3a8672348ff6b789e416762ad53e69063138b8eb4d8780101658f24b2369f1a8e09499226b467d8bc0c4e03e1dc903df857eeb3c67733d21b6aaee2840e429")

	// VoteTicket(count uint64, price *big.Int, nodeId discover.NodeID)
	var VoteTicket [][]byte
	VoteTicket = make([][]byte, 0)
	VoteTicket = append(VoteTicket, byteutil.Uint64ToBytes(0xf1))
	VoteTicket = append(VoteTicket, []byte("VoteTicket"))
	VoteTicket = append(VoteTicket, byteutil.Uint64ToBytes(1))
	VoteTicket = append(VoteTicket, big.NewInt(1).Bytes())
	VoteTicket = append(VoteTicket, nodeId)
	bufVoteTicket := new(bytes.Buffer)
	err := rlp.Encode(bufVoteTicket, VoteTicket)
	if err != nil {
		fmt.Println(err)
		t.Errorf("VoteTicket encode rlp data fail")
	} else {
		fmt.Println("VoteTicket data rlp: ", hexutil.Encode(bufVoteTicket.Bytes()))
	}

	// GetCandidateTicketIds(nodeId discover.NodeID)
	var GetCandidateTicketIds [][]byte
	GetCandidateTicketIds = make([][]byte, 0)
	GetCandidateTicketIds = append(GetCandidateTicketIds, byteutil.Uint64ToBytes(0xf1))
	GetCandidateTicketIds = append(GetCandidateTicketIds, []byte("GetCandidateTicketIds"))
	GetCandidateTicketIds = append(GetCandidateTicketIds, nodeId)
	bufGetCandidateTicketIds := new(bytes.Buffer)
	err = rlp.Encode(bufGetCandidateTicketIds, GetCandidateTicketIds)
	if err != nil {
		fmt.Println(err)
		t.Errorf("GetCandidateTicketIds encode rlp data fail")
	} else {
		fmt.Println("GetCandidateTicketIds data rlp: ", hexutil.Encode(bufGetCandidateTicketIds.Bytes()))
	}

	// GetTicketDetail(ticketId common.Hash)
	ticketId := common.Hex2Bytes("ca515bb10122368d4e4418d0357508fefff0ec0bd190efbc23be197e8907af61")
	var GetTicketDetail [][]byte
	GetTicketDetail = make([][]byte, 0)
	GetTicketDetail = append(GetTicketDetail, byteutil.Uint64ToBytes(0xf1))
	GetTicketDetail = append(GetTicketDetail, []byte("GetTicketDetail"))
	GetTicketDetail = append(GetTicketDetail, ticketId)
	bufGetTicketDetail := new(bytes.Buffer)
	err = rlp.Encode(bufGetTicketDetail, GetTicketDetail)
	if err != nil {
		fmt.Println(err)
		t.Errorf("GetTicketDetail encode rlp data fail")
	} else {
		fmt.Println("GetTicketDetail data rlp: ", hexutil.Encode(bufGetTicketDetail.Bytes()))
	}
}

func TestTicketPoolDecode(t *testing.T) {
	//HexString -> []byte
	rlpcode, _ := hex.DecodeString("f8a28800000000000000f18a566f74655469636b65748800000000000003e801b88230783166336138363732333438666636623738396534313637363261643533653639303633313338623865623464383738303130313635386632346232333639663161386530393439393232366234363764386263306334653033653164633930336466383537656562336336373733336432316236616165653238343065343239")
	var source [][]byte
	if err := rlp.Decode(bytes.NewReader(rlpcode), &source); err != nil {
		fmt.Println(err)
		t.Errorf("TestRlpDecode decode rlp data fail")
	}

	for i, v := range source {
		fmt.Println("i: ", i, " v: ", hex.EncodeToString(v))
	}
}