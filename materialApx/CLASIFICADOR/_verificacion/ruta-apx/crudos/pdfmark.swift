import PDFKit
import AppKit
let d = PDFDocument(url: URL(fileURLWithPath: CommandLine.arguments[1]))!
for i in 0..<d.pageCount {
  let page = d.page(at: i)!
  let r = page.bounds(for: .mediaBox)
  let sc: CGFloat = 2
  let w = Int(r.width*sc), h = Int(r.height*sc)
  let ctx = CGContext(data: nil, width: w, height: h, bitsPerComponent: 8, bytesPerRow: w*4, space: CGColorSpaceCreateDeviceRGB(), bitmapInfo: CGImageAlphaInfo.premultipliedLast.rawValue)!
  ctx.setFillColor(CGColor(red:1,green:1,blue:1,alpha:1)); ctx.fill(CGRect(x:0,y:0,width:w,height:h))
  ctx.scaleBy(x: sc, y: sc); page.draw(with: .mediaBox, to: ctx)
  let data = ctx.data!.bindMemory(to: UInt8.self, capacity: w*h*4)
  func yellowAt(_ pdfY: CGFloat) -> Bool {
    let row = h - 1 - Int((pdfY - r.minY)*sc); if row < 0 || row >= h { return false }
    var cnt = 0
    for x in stride(from: 0, to: w, by: 2) { let o = (row*w + x)*4; if data[o] > 200 && data[o+1] > 200 && data[o+2] < 120 { cnt += 1 } }
    return cnt > 10 }
  print("=== página \(i+1)")
  guard let all = page.selection(for: r) else { continue }
  for ln in all.selectionsByLine() {
    let b = ln.bounds(for: page); let s = (ln.string ?? "").trimmingCharacters(in: .whitespacesAndNewlines)
    if s.isEmpty { continue }
    print((yellowAt(b.midY) ? "[✔] " : "    ") + s)
  }
}
